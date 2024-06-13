package command; // Package declaration

import java.io.PrintWriter; // Importing PrintWriter class from java.io package

// command for displaying help message
public class HelpCommand implements Command {

    // Overriding the execute method defined in the command interface
    @Override
    public void execute(PrintWriter writer) {
        // Creating a StringBuilder to build the help message
        StringBuilder helpMessage = new StringBuilder();

        // Appending available commands and their descriptions to the help message
        helpMessage.append("Available commands:\n");
        helpMessage.append("  deposit <amount> - Deposits <amount> into your account.\n");
        helpMessage.append("  transfer <amount> <toClientId> - Transfers <amount> to another account.\n");
        helpMessage.append("  balance - Displays your current balance.\n");
        helpMessage.append("  transaction - Displays the list of your transactions.\n");
        helpMessage.append("  help - Displays this help message.\n");
        helpMessage.append("  exit - Disconnects from the server.\n");

        // Writing the help message to the PrintWriter
        writer.println(helpMessage);
    }
}
