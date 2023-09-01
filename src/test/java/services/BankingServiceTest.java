package services;

import models.BancAccount;
import models.BankAccountTest;
import models.Customer;
import models.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.Assert.assertEquals;

public class BankingServiceTest {

    @Test
    public void addNewCustomerTest(){
        BankingServiceClass bankingServiceClass = new BankingServiceClass();
        BancAccount bankAccount1 = new BancAccount("12345", 1000.0);

        Customer customer1 = new Customer("Elon Mask", "x1", bankAccount1);

        bankingServiceClass.addCustomer(customer1);


        List<Customer> expectedCustomerList = new ArrayList<>();
        expectedCustomerList.add(customer1);
        assertEquals(expectedCustomerList, bankingServiceClass.getCustomerList(), "Two customer list are not equals");

    }

    @Test
    public void findingCustomerTest(){
        BankingServiceClass bankingServiceClass = new BankingServiceClass();
        BancAccount bancAccount = new BancAccount("12345", 1000.0);
        Customer customer1 = new Customer("Elon Mask", "x1", bancAccount);

        //this is action test
        bankingServiceClass.addCustomer(customer1);

        Customer actualResultCustomerObj = bankingServiceClass.findCustomer("x1");
        assertEquals(actualResultCustomerObj.getName(), "Elon Mask");
        assertEquals(actualResultCustomerObj.getCustomerId(), "x1");
    }


    @Test
    public void findingCustomerThatDoesntExist(){
        BankingServiceClass bankingServiceClass = new BankingServiceClass();
        BancAccount bancAccount1 = new BancAccount("12345", 1000.0);
        Customer customer1 = new Customer("Elon Mask", "x1", bancAccount1);

        //this is action test
        bankingServiceClass.addCustomer(customer1);

        Customer actualResultCustomerObj = bankingServiceClass.findCustomer("beta123");
        assertNull(actualResultCustomerObj, "finding a customer that doesnt exist should return null");

    }


    @Test
    public void findAccountWithinAccountListTest(){

    }



    @Test
    public void testPerformDepositTransaction(){

        Transaction transaction = new Transaction("TXN0001", "Deposit", 500.0, "12345", "x1");
        BancAccount bankAccount1 = new BancAccount("12345", 1000.0);

        Customer customer1 = new Customer("Elon Mask", "x1", bankAccount1);
        BankingServiceClass bankingServiceClass = new BankingServiceClass();
        bankingServiceClass.addCustomer(customer1);
        try {
            bankingServiceClass.performTransaction(transaction);
            assertEquals(1500.0, bankAccount1.getBalance(), "Deposit is not completed");
        }catch (Exception e){
            fail("perform a transaction with valid transaction failed");
        }
    }



    @Test
    public void testPerformWithdrawWithInsufficientFund(){

        Transaction transaction = new Transaction("TXN0001", "Withdraw", 1500.0, "12345", "x1");
        BancAccount bankAccount1 = new BancAccount("12345", 1000.0);

        Customer customer1 = new Customer("Elon Mask", "x1", bankAccount1);

        BankingServiceClass bankingServiceClass = new BankingServiceClass();
        bankingServiceClass.addCustomer(customer1);
        try{
            bankingServiceClass.performTransaction(transaction);
            assertEquals(1000.0, bankAccount1.getBalance(), "withdraw balance mismatch");

        }catch (Exception e){
            fail("Withdraw with insufficient fund error" + e.getMessage());
        }
    }







}
