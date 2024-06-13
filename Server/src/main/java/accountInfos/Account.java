package accountInfos; // Package declaration

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Account class represents a bank account.
 * It contains information about the account balance and a list of transactions.
 */
public class Account {

    private double balance; // Private member variable to store the account balance

    // List of transactions associated with the account
    List<Transactions> listTransaction; // Declaration of listTransaction

    /**
     * Constructs an Account object with the specified initial balance.
     *
     * @param balance The initial balance of the account.
     */
    public Account(double balance){
        this.balance = balance; // Assigning the initial balance passed to the constructor
        listTransaction = new ArrayList<>(); // Initializing listTransaction as an ArrayList
    }

    // Method to return the list of transactions
    public List<Transactions> getListTransaction() {
        return listTransaction;
    }

    // Method to increase the account balance and add a transaction for charging an amount
    public void chargeAmount(String type, double amount){
        this.balance += amount; // Increasing the account balance
        String date = new Date().toString(); // Getting the current date and time as a string
        Transactions transactions = new Transactions(type, date, amount, "Self", "Self"); // Creating a transaction object
        listTransaction.add(transactions); // Adding the transaction to the list of transactions
    }

    // Method to decrease the account balance and add a transaction for diminishing an amount
    public void diminueAmount(double amount){
        this.balance -= amount; // Decreasing the account balance
        String date = new Date().toString(); // Getting the current date and time as a string
        String type = ""; // Empty type for diminishing amount
        Transactions transactions = new Transactions(type, date, amount, "Self", "Self"); // Creating a transaction object
        listTransaction.add(transactions); // Adding the transaction to the list of transactions
    }

    // Method to add a transaction for transferring an amount between accounts
    public void addTransaction(double amount, String sender, String receiver){
        String date = new Date().toString(); // Getting the current date and time as a string
        String type = "Transaction"; // Type for a regular transaction
        Transactions transactions = new Transactions(type, date, amount, receiver, sender); // Creating a transaction object
        listTransaction.add(transactions); // Adding the transaction to the list of transactions
    }

    // Method to get the current account balance
    public double getBalance() {
        return balance; // Returning the current balance
    }

}
