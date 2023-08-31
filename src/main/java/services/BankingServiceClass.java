package services;

import models.BancAccount;
import models.Transaction;
import models.Customer;

import java.util.ArrayList;
import java.util.List;


public class BankingServiceClass {
    private List<Customer> customerList;
    private List<Transaction> transactionList;

    public BankingServiceClass() {
        this.customerList = new ArrayList<>();
        this.transactionList = new ArrayList<>();
    }


    public void addCustomer(Customer customer){

        customerList.add(customer);
    }

    public Customer findCustomer(String customerId){
        for (Customer customer : customerList){
            if (customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    public BancAccount findAccount(String accountId){
        for (Customer customer : customerList){
            if(customer.getBancAccount().getAccountNumber().equals(accountId)){
                return customer.getBancAccount();
            }
        }
        return null;
    }

    public void performTransaction(Transaction transaction){
        String accountId = transaction.getAccountId();
        BancAccount account = findAccount(accountId);

        if (account != null ) {
            String customerId = transaction.getCustomerId();
            Customer customer = findCustomer(customerId);

            if (customer != null) {
                if (transaction.getType().equals("Deposit")) {
                    account.deposit(transaction.getAmount());
                } else if (transaction.getType().equals("withdraw")) {
                    account.withdraw(transaction.getAmount());
                }

                transactionList.add(transaction);
            } else {
                System.out.println("Customer not found");
            }
        }else {
                System.out.println("Account not found");
            }
        }

        public List<Customer> getCustomerList(){
        return customerList;
        }


}
