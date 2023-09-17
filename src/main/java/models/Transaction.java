package models;

public class Transaction {
    private String transactionId;
    private String type;
    private double amount;
    private String accountId;
    private String customerId;

    public Transaction(String transactionId, String type, double amount, String accountId, String customerId) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.accountId = accountId;
        this.customerId = customerId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
