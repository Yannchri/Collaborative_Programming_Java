package accountInfos; // Declares the package name

import accountInfos.Account; // Imports the Account class from the same package

// Class representing a transaction
public class Transactions {

    private String date; // Stores the date of the transaction
    private double amount; // Stores the amount of the transaction
    private String receiver; // Stores the receiver of the transaction
    private String sender; // Stores the sender of the transaction
    private String type; // Stores the type of the transaction

    // Constructor to initialize transaction details
    public Transactions(String type, String date, double amount, String receiver, String sender){
        this.type = type; // Initializes the type of transaction
        this.date = date; // Initializes the date of transaction
        this.amount = amount; // Initializes the amount of transaction
        this.sender = sender; // Initializes the sender of transaction
        this.receiver = receiver; // Initializes the receiver of transaction
    }

    // Getter method to retrieve the type of transaction
    public String getType() {
        return type; // Returns the type of transaction
    }

    // Method to get details of the transaction
    public String getInfosTransaction(){
        // Constructs and returns a string containing transaction details
        return "Transaction : "
                + "\nType of transaction : " + this.type
                + "\nDate : " + this.date
                + "\nOn the account : " + this.receiver
                + "\nFrom the account : " + this.sender
                + "\nAmount : " + this.amount + "\n_______________\n";
    }

}
