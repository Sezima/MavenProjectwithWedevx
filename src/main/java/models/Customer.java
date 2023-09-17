package models;

public class Customer {
    private String name;
    private String customerId;
    private BankAccount bankAccount;

    public Customer(String name, String customerId, BankAccount bankAccount) {
        this.name = name;
        this.customerId = customerId;
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
