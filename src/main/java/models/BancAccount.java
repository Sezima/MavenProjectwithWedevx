package models;

public class BancAccount {
    private  String accountNumber;
    private double balance;

    public BancAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }


    //method

    public  void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        } else {
            System.out.println("Into efficient balance");
            return false;
        }
    }

    //what do we add in the models package? so most projects will have this models package or they are sometiomes called domain
    // models is basically consist POJO
    //POJO id a plain old jav aa object
    // where the object the class only has a constractor and getters and setter and not toom many things in there

    // in models we are basically creatind data types our custom data types for our project in the customer class.
// if you have pojo you don't need to create unit tests



}
