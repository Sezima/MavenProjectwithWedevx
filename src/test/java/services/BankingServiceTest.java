package services;

import models.BankAccount;
import models.Customer;
import models.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankingServiceTest {
    static BankingService bankingService;
    BankAccount bankAccount1;
    Customer customer1;

    //when you see lines of code that are repeating in
    // every single test within on test class
    //those lines are good candidates to be hooks
    //@BeforeEach, @BeforeAll, @AfterEach, @AfterAll --> these all called hooks

    @BeforeAll
    public static void beforeAll(){
        bankingService = new BankingService();
    }

    @BeforeEach
    public void beforEach(){
        //pre conditional steps
        bankAccount1 = new BankAccount("12345", 1000.0);
        customer1 = new Customer("Elon Musk", "x1", bankAccount1);
    }

    @AfterEach
    public void cleanUp(){
        // start every test from empty cache.
        //so that it ensures each test is starting from of app's default state
        //end each test is independent of each other

        bankingService.clearCache();
    }

    @Test
    public void addNewCustomerTest(){

        //action test
        bankingService.addCustomer(customer1);
        List<Customer> expectedListOfCustomer = new ArrayList<>();
        expectedListOfCustomer.add(customer1);
        assertEquals(expectedListOfCustomer, bankingService.getCustomerList(), "two customer lists are not equal");
    }

    @Test
    public void findCustomerWithinCustomerListTest(){

        bankingService.addCustomer(customer1);

        Customer actualResultCustomerObj = bankingService.findCustomer("x1");
        assertEquals(actualResultCustomerObj.getName(), "Elon Musk");
        assertEquals(actualResultCustomerObj.getBankAccount().getAccountNumber(), "12345");
    }
    @Test
    public void findingCustomerTest(){

        //this is action test
        bankingService.addCustomer(customer1);

        Customer actualResultCustomerObj = bankingService.findCustomer("x1");
        assertEquals(actualResultCustomerObj.getName(), "Elon Musk");
        assertEquals(actualResultCustomerObj.getCustomerId(), "x1");
    }

    @Test
    public void findCustomerThatDoesntExistTest(){

        bankingService.addCustomer(customer1);

        Customer actualResultCustomerObj = bankingService.findCustomer("beta123");

        assertNull(actualResultCustomerObj, "finding a customer that doesnt exist should return null");
    }

    @Test
    public void findAccountWithinAccountListTest(){

    }

    @Test
    public void performTransactionWithNullCustomer(){

        Transaction transaction = new Transaction("TXN001", "Deposit", 500.0, "12345", "x1");

        try {
            assertThrows(Exception.class, () -> bankingService.performTransaction(transaction));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testPerformDepositTransaction(){

        Transaction transaction = new Transaction("TXN0001", "Deposit", 500.0, "12345", "x1");

        bankingService.addCustomer(customer1);
        try {
            bankingService.performTransaction(transaction);
            assertEquals(1500.0, bankAccount1.getBalance(), "Deposit is not completed");
        }catch (Exception e){
            fail("perform a transaction with valid transaction failed");
        }
    }

    @Test
    public void testPerformWithdrawWithSufficientFund(){

        Transaction transaction = new Transaction("TXN0001", "Withdraw", 300.0, "12345", "x1");

        bankingService.addCustomer(customer1);
        try{
            bankingService.performTransaction(transaction);
            assertEquals(700.0, bankAccount1.getBalance(), "withdraw balance mismatch");

        }catch (Exception e){
            fail("Withdraw with sufficient fund is not completed" + e.getMessage());
        }
    }

    @Test
    public void testPerformWithdrawWithInsufficientFund(){

        Transaction transaction = new Transaction("TXN0001", "Withdraw", 1500.0, "12345", "x1");

        bankingService.addCustomer(customer1);
        try{
            bankingService.performTransaction(transaction);
            assertEquals(1000.0, bankAccount1.getBalance(), "withdraw balance mismatch");

        }catch (Exception e){
            fail("Withdraw with insufficient fund error" + e.getMessage());
        }
    }

}
