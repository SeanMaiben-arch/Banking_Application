
public class Runner {

	
	public static void main(String[] args) {
	    // Create a new banking application instance
	    Account account1 = new Account("Sean Maiben", 500);
	    BankHandling bh = new BankHandling();
	    Loans loans = new Loans(bh);

	  
	//**BankHandling class methods**//    
	
	  bh.addAccount(account1.getAccountName(), account1);	//add account to Hashmap
	  bh.addMoney(account1.getAccountName(), 450);			//add money to account 
	  bh.findMyAccount(account1.getAccountName());			//check if account exists in Hashmap collection
	  bh.withdraw(account1.getAccountName(), 500);				//withdraw money from users existing balance
	  bh.getTotalDeps();									//check total deposit amount for the bank
	
	
	//**Loans class methods**//
	  
	  loans.loanApproval(account1.getAccountName(), 300);		//tries to get loan for an amount of 300 for the current account object
	  loans.loanRepayment(account1.getAccountName(), 300);		//tries to repay loan for a repayment amount of 300
	  bh.getTotalDeps();									//check bank total deposits amount (which should update before and after loan is provided & repaid
	
	
	//**Account class methods**//
	  
	  account1.getAccountName(); //returns name associated with current account object
	  account1.getBalance(); //returns the balance figure of the current account object
	  account1.getLoan(); //returns the loan figure of the current account object
	
	
	}
	
	
	
}
