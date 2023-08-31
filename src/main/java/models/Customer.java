package models;

public class Customer {

    private String name;
    private String customerId;
    private  BancAccount bancAccount;

    public Customer(String name, String customerId, BancAccount bancAccount) {
        this.name = name;
        this.customerId = customerId;
        this.bancAccount = bancAccount;
    }


    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BancAccount getBancAccount() {
        return bancAccount;
    }





}
