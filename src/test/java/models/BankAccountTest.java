package models;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount("1234", 1000.0);
        bankAccount.deposit(500.0);

        assertEquals(1500, bankAccount.getBalance(), "deposit functionality bug");
    }

   //withdraw functionality have a requirement for
    //withdraws only possible if the current balance is more or equal to amount

    @Test
    public void testWithdrawSufficientFunds(){
        BankAccount bankAccount = new BankAccount("1234", 1000.0);
        boolean actualResult = bankAccount.withdraw(500.0);

        assertTrue(actualResult, "withdraw didn't return true");
        assertEquals(500.0, bankAccount.getBalance(), "withdraw balance mismatch");
    }

    @Test
    public void testWithdrawInsufficientFunds(){
        BankAccount bankAccount = new BankAccount("1234", 100.0);
        boolean actualResult = bankAccount.withdraw(200.0);

        assertFalse(actualResult, "withdraw insufficient funds return true");
        assertEquals(100.0, bankAccount.getBalance(), "insufficient funds withdraw call alter the balance");
    }
}
