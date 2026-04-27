import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class AccountTestClass {

    private static Account account;

    @BeforeAll
    static void setupAll() {  
        account = new Account("Sean Maiben", 500);
    }

    @AfterAll
    static void tearDownAll() {
        account = null;
    }

    @Test
    void depositTest() {
        account.deposit(200);
        assertEquals(700, account.getBalance());
    }

    @Test
    void withdrawTest() {
        account.withdraw(200);
        assertEquals(500, account.getBalance());
    }

    @Test
    void setLoanTest() {
        account.SetLoan(200);
        assertEquals(-200, account.getLoan());
    }

    @Test
    void repayLoanTest() {
        account = new Account("Sean Maiben", 500);

        account.SetLoan(200);
        account.repayLoan(50);

        assertEquals(-150, account.getLoan());
    }

    @Test
    void getAccountNameTest() {
        assertEquals("Sean Maiben", account.getAccountName());
    }

    @Test
    void getBalanceTest() {
        assertEquals(500, account.getBalance());
    }
}
