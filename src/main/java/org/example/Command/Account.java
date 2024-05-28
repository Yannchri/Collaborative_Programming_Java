package org.example.Command;

public class Account {
    private String username;
    private double balance;

    public Account(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }
}
