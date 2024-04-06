package data;

import java.util.List;

public class Account {
    private final int number;
    private final AccountType accountType;
    private double balance;
    private final List<Transaction> transactions;

    public Account(int number, AccountType accountType, double balance, List<Transaction> transactions) {
        this.number = number;
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = transactions;
    }

    public int getNumber() {
        return number;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
