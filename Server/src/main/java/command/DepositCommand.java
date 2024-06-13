package command; // Package declaration

import accountInfos.ClientInfos; // Importing ClientInfos class from the accountInfos package
import java.io.PrintWriter; // Importing PrintWriter class from java.io package

// command for depositing money into an account
public class DepositCommand implements Command {
    private ClientInfos account; // Declaring a private member variable of type ClientInfos to store the account information
    private double amount; // Declaring a private member variable to store the deposit amount

    // Constructor to initialize the DepositCommand with a ClientInfos object and an amount
    public DepositCommand(ClientInfos account, double amount) {
        this.account = account; // Assigning the provided ClientInfos object to the private member variable
        this.amount = amount; // Assigning the provided amount to the private member variable
    }

    // Overriding the execute method defined in the command interface
    @Override
    public void execute(PrintWriter writer) {
        // Calling the chargeAmount method of the ClientInfos object to deposit the amount
        account.getClientAccount().chargeAmount("Deposit", amount);
        // Printing a message indicating the deposit amount and the new balance
        writer.println("Deposited: $" + amount + ". New Balance: $" + account.getClientAccount().getBalance());
    }
}
