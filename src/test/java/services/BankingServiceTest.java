package services;

import models.BancAccount;
import models.BankAccountTest;
import models.Customer;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.Assert.assertEquals;

public class BankingServiceTest {
    public void addNewCustomerTest(){
        BankingServiceClass bankingServiceClass = new BankingServiceClass();
        BancAccount bankAccount1 = new BancAccount("12345", 1000.0);

        Customer customer1 = new Customer("Elon Mask", "x1", bankAccount1);

        bankingServiceClass.addCustomer(customer1);


        List<Customer> expectedCustomerList = new ArrayList<>();
        expectedCustomerList.add(customer1);
        assertEquals(expectedCustomerList, bankingServiceClass.getCustomerList(), "Two customer list are not equals");

    }



}
