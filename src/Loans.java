
public class Loans {
private BankHandling bank;
		
	//constructor so that whenever a new Loans object is created; it must be initialized with the BankHandling class obj
	Loans(BankHandling bank){
		this.bank = bank; }
	
	
	
	public boolean loanApproval(String name, double request) {
		Account acc = bank.findMyAccount(name);								//check is user currently has an account
		
		if(request < bank.TotalDeposits) {									//check if the bank has the funds to offer the loan
			bank.TotalDeposits -= request;									//deducts loan from banks total deposits
			acc.deposit(request); 											//adds loan to existing user balance
			acc.SetLoan(request); 											//sets the loan variable for this specific user to reflect the approved loan amnt
			
		System.out.println("Your loan has been approved!, your new account balance is-> " + acc.getBalance() + " your outstanding loan amount is -> " + acc.getLoan());	 	//returns the users updated balance after addition of loan & current loan amnt
		return true;
		}else {
			System.out.println("Your loan has been denied, please contact customer support for further details");			//if account has insufficient funds for the requested loan then the users request will be denied 
			return false; } 	}
	
	
	
	
	public double loanRepayment(String name, double repayment) throws IllegalArgumentException {
		Account acc = bank.findMyAccount(name); 																//set variable 'acc' to be the matching account (if it exists)
		double currentBal = acc.getBalance();																	//sets variable 'currentBal' to be the matching accounts balance																										
		
		if (currentBal >= repayment) {

		    acc.repayLoan(repayment);																			//if the acc has a sufficient balance then loan amnt is deducted from
		    acc.withdraw(repayment);																			//the repayment amnt is deducted from the users acc
		    bank.TotalDeposits += repayment;																	//the repayment is added back to the total Deposit amount of the bank

		    if (acc.getLoan() > 0) {																			//if the loan figure is positive (I.E overpaid), then the excess is refunded to the user
		       System.out.println("Your loan has been paid in excess, and amount of " + LoanOverpayment(acc) + " has been refunded to your accont");
		        return acc.loan;
		    }

		    System.out.println("Your repayment has been submitted, remaining loan -> " + acc.loan);				//otherwise we just submit the payment against the outstanding loan
		    return acc.loan;

		} else {
		    throw new IllegalStateException("Insufficient balance for repayment");
		} }
	
	
	
	
	public double LoanOverpayment(Account acc) {    //this method works out the overpayment amnt of a loan and refunds the user as well as resetting the loan amnt 
		double excess = acc.loan;
		acc.deposit(excess);
		acc.loan = 0;
		return excess;}
	
	
	
	
	}

