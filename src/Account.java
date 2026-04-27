

public class Account {
    // Represents a single bank account with account holder name, balance, and loan amount
protected String accountHolder; // Name of the account holder
protected double balance;       // Current account balance
protected double loan;          // Outstanding loan amount

//the creation of a new account object;
public Account(String accountName, double accBal) {
    this.accountHolder = accountName;
    this.balance = accBal;
    this.loan = 0; }


			
		//gets & returns the specific accountholders name 
			public String getAccountName() {
				return this.accountHolder; }
			
		//gets & returns current balance amnt
			public double getBalance() {			//***getter methods for the name, balance and initial deposit value***
				return this.balance; }
			
		//updates the specific accs balance amnt to reflect 
		//depositied money
			public void deposit(double money) {
			if (money < 0) throw new IllegalArgumentException("cannot deposit a negative amount!");
			this.balance += money; }
			
			//updates the specific accs balance amnt to reflect 
			//withdrawn money
			public void withdraw(double withdrawal) {
			if (withdrawal < 0) throw new IllegalArgumentException("cannot withdraw a negative amount!");
			  this.balance -= withdrawal; }
			
			
			
							//if loan is approved; updates the specific accounts loan variable
									public void SetLoan(double loanAmnt) {
										this.loan -= loanAmnt; }
									
																										//***methods called from Loans class***
							//if repayment amnt is possible; the specific accs loan var is updated
									public void repayLoan(double repayment) {							
										this.loan += repayment; }
									
							//gets & returns the current outstanding loan amount for a specific account / if loan is in a positive balance (overpaid) adds the overpaid amount to the users account balance		
									public double getLoan() {
										return this.loan; }


}
