package api.domains;

public class AccountResponseModel {
    private int id;
    private String name;
    private int accountNumber;
    private double currentBalance;
    private double openingBalance;
    private double interestRate;
    private double paymentAmount;
    private int paymentTerm;
    private AccountTypeModel accountType;
    private AccountOwnershipModel ownershipType;
    private AccountStandingModel accountStanding;
    private String dateOpened;
    private String dateClosed;
    private String paymentDue;

    // Constructors

    public AccountResponseModel() {
        // Default constructor
    }

    public AccountResponseModel(int id, String name, int accountNumber, double currentBalance,
                                double openingBalance, double interestRate, double paymentAmount,
                                int paymentTerm, AccountTypeModel accountType, AccountOwnershipModel ownershipType,
                                AccountStandingModel accountStanding, String dateOpened, String dateClosed,
                                String paymentDue) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.openingBalance = openingBalance;
        this.interestRate = interestRate;
        this.paymentAmount = paymentAmount;
        this.paymentTerm = paymentTerm;
        this.accountType = accountType;
        this.ownershipType = ownershipType;
        this.accountStanding = accountStanding;
        this.dateOpened = dateOpened;
        this.dateClosed = dateClosed;
        this.paymentDue = paymentDue;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(int paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public AccountTypeModel getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeModel accountType) {
        this.accountType = accountType;
    }

    public AccountOwnershipModel getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(AccountOwnershipModel ownershipType) {
        this.ownershipType = ownershipType;
    }

    public AccountStandingModel getAccountStanding() {
        return accountStanding;
    }

    public void setAccountStanding(AccountStandingModel accountStanding) {
        this.accountStanding = accountStanding;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(String paymentDue) {
        this.paymentDue = paymentDue;
    }
}
