package Command; // Package declaration

import accountInfos.ClientInfos; // Importing ClientInfos class from the accountInfos package
import java.io.PrintWriter; // Importing PrintWriter class from java.io package

// Class representing a BalanceCommand, implementing the Command interface
public class BalanceCommand implements Command {
    private ClientInfos account; // Declaring a private member variable of type ClientInfos

    // Constructor to initialize the BalanceCommand with a ClientInfos object
    public BalanceCommand(ClientInfos account) {
        this.account = account; // Assigning the provided ClientInfos object to the private member variable
    }

    // Overriding the execute method defined in the Command interface
    @Override
    public void execute(PrintWriter writer) {
        // Printing the current balance of the client's account using PrintWriter
        writer.println("Current Balance: $" + account.getClientAccount().getBalance());
    }
}
