package command; // Package declaration

import java.io.PrintWriter; // Importing PrintWriter class from java.io package

// command for displaying help message
public class HelpCommand implements Command {

    // Overriding the execute method defined in the command interface
    @Override
    public void execute(PrintWriter writer) {
        // Creating a StringBuilder to build the help message
        // Initialize the string for the help message
        String helpMessage = "";

        // Appending available commands and their descriptions to the help message
        helpMessage += "Available commands:\n";
        helpMessage += "  deposit <amount> - Deposits <amount> into your account.\n";
        helpMessage += "  transfer <amount> <toClientId> - Transfers <amount> to another account.\n";
        helpMessage += "  balance - Displays your current balance.\n";
        helpMessage += "  transaction - Displays the list of your transactions.\n";
        helpMessage += "  help - Displays this help message.\n";
        helpMessage += "  exit - Disconnects from the server.\n";

        // Writing the help message using PrintWriter
        writer.println(helpMessage);
    }
}
