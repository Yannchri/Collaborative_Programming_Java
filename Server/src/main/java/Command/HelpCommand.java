package Command;
import java.io.PrintWriter;

public class HelpCommand implements Command {



    @Override
    public void execute(PrintWriter writer) {
        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append("Available commands:\n");
        helpMessage.append("  deposit <amount> - Deposits <amount> into your account.\n");
        helpMessage.append("  transfer <amount> <toClientId> - Transfers <amount> to another account.\n");
        helpMessage.append("  balance - Displays your current balance.\n");
        helpMessage.append("  transaction - Displays the list of your transaction.\n");
        helpMessage.append("  help - Displays this help message.\n");
        helpMessage.append("  exit - Disconnects from the server.\n");

        writer.println(helpMessage.toString());
    }
}