import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BankHandlingTestClass {
	public static BankHandling BankHandlingClass;
	public static Account TestAccount;
	
	@BeforeEach
	public void dummyAcc() {							//initializes a dummy account with a name and balance
		TestAccount = new Account("Sean Maiben", 500);
		BankHandlingClass = new BankHandling();
		BankHandlingClass.addAccount("Sean Maiben", TestAccount);}
	
	@AfterEach
	public void TearDown() { //after each test the dummy account is reset
		TestAccount = null;
	}
		
	@Test
	void AddMoneyTest() {
		double RealResult =	BankHandlingClass.addMoney("Sean Maiben", 250);
	assertEquals(750, RealResult);}
	

	@ParameterizedTest 
	@ValueSource(strings = {"Sean Maiben", "", "Sean"})
	void FindMyAaccountExceptionTest(String name) {
	assertThrows(IllegalArgumentException.class,() -> {BankHandlingClass.findMyAccount(name);});}
	
	
	@Test 
	void WithdrawFromAccTest() {
		boolean Actual = BankHandlingClass.withdraw("Sean Maiben", 300);
		boolean Expected = true;
	assertEquals(Expected, Actual);}
	
	
	@Test
	void CheckBankDepositTest() {
		double Actual = BankHandlingClass.getTotalDeps();
	assertEquals(500, Actual);}


}
