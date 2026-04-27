import java.util.HashMap;
import java.util.Map;

public class BankHandling {
	protected Map<String, Account> AllAccs = new HashMap<>(); 
	protected double TotalDeposits = 0.0;
	
	
	 
	public void addAccount(String name, Account account) {
	    AllAccs.put(name, account);																			//implements a hashmap to use the name of the account holder as the key to be able to fetch their associated account
	    TotalDeposits += account.getBalance(); 
	    System.out.println(account.getAccountName() + " has successfully been added to the system");}
	
	

	public double addMoney(String name, double money) {
	if(money < 0) {throw new IllegalArgumentException("you cannot add a negative balance to your account!");}
	
		Account account = findMyAccount(name);																//this method locates an existing account(if it does) and adds the deposited money to the Total Deposits of the bank 
		TotalDeposits += money;																				//the updated balance is then printed out to the user 
		account.deposit(money);
		System.out.println("amount of " + money + " has been added to account, updated balance is -> " + account.getBalance());
		return account.getBalance();}

	
	
	public Account findMyAccount(String name) {																//this method locates if an account exists by searching the name provided against the existing keys already within the hashmap
	if(name == null) {throw new IllegalArgumentException("name cannot be null!");}												
		if(AllAccs.containsKey(name)) 																		//if the name provided matches an existing key in the hashmap then we return the account of the user 
			return AllAccs.get(name);         				
			
	throw new IllegalArgumentException("the name entered does not match any existing account -> " + name);}	//otherwise we throw an exception to let the user know the name provided doesn't match any accounts currently 
	
	
	
	
	public boolean withdraw(String name, double request) { 													//this method checks if the requested withdrawal amnt exceeds the existing money within the account presently
		Account account = findMyAccount(name);																//we first make sure the users account exists
		
	if(request <= 0) { throw new IllegalArgumentException("You cannot withdraw a negative/null balance!"); } //if user attempts to withdraw a null or negative balance, exception gets thrown
																								 
		if(account.getBalance() >= request) {
		TotalDeposits -= request;																												//then if the user has a sufficient balance, we deduct the withdrawal from the bankHandling classes TotalDeposits variable
		account.withdraw(request);																												//then use the withdraw() method in the Account class to update this users balance for their account
		System.out.println("an amount of " + request + " has been withdrawn. Your updated Account balance is -> "+ account.getBalance());		//print out the users updated balance after withrawal has been deducted 
			return true;
		}
		System.out.println("requested amount exceeds account balance!");									//if the user has insufficient fund for the withdrawal in their account, we let them know & return false
		return false; }
	
	
	
		public double getTotalDeps() { 																		//this method returns the total deposits amount for the bank overall
		System.out.println("The current overall Deposit amount for this bank is -> " + TotalDeposits);
		return TotalDeposits;}


			}
	
	

