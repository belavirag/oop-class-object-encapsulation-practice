package dev.belavirag.practice;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private String customerName, email, phoneNumber;

    private static int accountNumberCounter = 0;

    public BankAccount(int accountNumber, double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(double balance, String customerName, String email, String phoneNumber) {
        this(BankAccount.incrementAccountNumber(), balance, customerName, email, phoneNumber);
    }

    public double withdraw(double amt) {
        if (amt <= 0) {
            throw new IllegalArgumentException("Cannot withdraw negative or 0 amount!");
        }

        if (balance - amt < 0) {
            throw new IllegalArgumentException("Cannot withdraw, insufficient balance!");
        }

        //TODO: underflow
        balance -= amt;
        return balance;
    }

    public double deposit(double amt) {
        if (amt <= 0) {
            throw new IllegalArgumentException("Cannot deposit negative or 0 amount!");
        }

        //TODO: overflow
        balance += amt;
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static int incrementAccountNumber() {
        return BankAccount.accountNumberCounter++;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
