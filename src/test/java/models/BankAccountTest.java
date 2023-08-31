package models;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    public void testDeposit(){
        BancAccount bancAccount = new BancAccount("1234", 1000.0);
        bancAccount.deposit(500.0);
        assertEquals(1500, bancAccount.getBalance(), "deposit functionality bud");

    }

    @Test
    //withdraw functionality have a requirement for withdraw functionality.
    //withdraw should only be possible if the current balance is more or equal to the amount requested
    public void testSufficientFinds(){
        BancAccount bancAccount = new BancAccount("1234", 1000.0);
        boolean actualresult = bancAccount.withdraw(500.0);
        assertTrue(actualresult, "withdraw bug");
        assertEquals(500.0, bancAccount.getBalance(), "withdraw balance wiswatch");
    }

    @Test
    public void testInsufficienFunds(){
        BancAccount bancAccount = new BancAccount("1234", 100.00);
        boolean actualresult = bancAccount.withdraw(200.0);
        assertFalse(actualresult, "withdraw insufficient funds returned true");
        assertEquals(100.00, bancAccount.getBalance(), "Insufficient funds withdraw call altred balance");
    }

}
