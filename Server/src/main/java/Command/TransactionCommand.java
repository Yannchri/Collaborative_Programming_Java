package Command; // Package declaration

import accountInfos.ClientInfos; // Importing ClientInfos class from the accountInfos package
import accountInfos.Transactions; // Importing Transactions class from the accountInfos package
import java.io.PrintWriter; // Importing PrintWriter class from java.io package
import java.util.List; // Importing List interface from java.util package

// Command for displaying transactions
public class TransactionCommand implements Command {
    private ClientInfos account; // Declaring a private member variable of type ClientInfos to store the account information

    // Constructor to initialize the TransactionCommand with a ClientInfos object
    public TransactionCommand(ClientInfos account) {
        this.account = account; // Assigning the provided ClientInfos object to the private member variable
    }

    // Overriding the execute method defined in the Command interface
    @Override
    public void execute(PrintWriter writer) {
        String message = ""; // Declaring a variable to store the transaction message

        // Getting the list of transactions associated with the client's account
        List<Transactions> listTransaction = account.getClientAccount().getListTransaction();

        // Iterating over each transaction in the list
        for (Transactions transactions : listTransaction) {
            // Checking if the transaction type is "Transaction" or "Deposit"
            if (transactions.getType().equals("Transaction")) {
                // Adding transaction details to the message
                message += transactions.getInfosTransaction();
            } else if (transactions.getType().equals("Deposit")) {
                message += transactions.getInfosDeposit();
            }
        }

        // Writing the transaction message to the PrintWriter
        writer.println(message);
    }
}
