import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoansTestClass {
	public static Loans LoansClass;
	public static Account Accountclass;
	public static BankHandling BankHandlingclass;
	
	@BeforeEach
	void resetState() {
	    Accountclass = new Account("Sean Maiben", 700);
	    BankHandlingclass = new BankHandling();
	    BankHandlingclass.addAccount("Sean Maiben", Accountclass);
	    LoansClass = new Loans(BankHandlingclass);
	}
	
	@Test
	@Timeout (value = 1000, unit = TimeUnit.MILLISECONDS)
	void loanApprovalTest() {
		boolean Actual = LoansClass.loanApproval("Sean Maiben", 400);
		boolean Expected = true;
		assertEquals(Expected, Actual);
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {50, 200, 250, 1000})
	void loanRepaymentParameterizedTest(double repayment) {

	    Account account = new Account("Sean Maiben", 500);
	    BankHandling bank = new BankHandling();
	    bank.addAccount("Sean Maiben", account);
	    Loans loans = new Loans(bank);

	    account.SetLoan(200);

	    if (repayment > account.getBalance()) {
	        assertThrows(IllegalStateException.class, () -> {
	            loans.loanRepayment("Sean Maiben", repayment);
	        });
	    } else {
	        double result = loans.loanRepayment("Sean Maiben", repayment);

	        if (repayment < 200) {
	            assertEquals(-200 + repayment, result);
	        } else {
	            assertEquals(0, result);
	        } 	} }
	
	
	@ParameterizedTest
	@ValueSource(doubles = {150})
	void loanOverpaymentParameterizedTest(double repayment) {

	    Account account = new Account("Sean Maiben", 500);
	    Loans loans = new Loans(new BankHandling());

	    account.SetLoan(100);        // loan = -100
	    account.repayLoan(repayment); // loan becomes positive (overpayment)

	    double result = loans.LoanOverpayment(account);

	    assertEquals(repayment - 100, result); // excess
	    assertEquals(0, account.getLoan());    // reset
	}

}
