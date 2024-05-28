package org.example.Command;

import java.io.PrintWriter;

public class HelpCommand implements Command {



    @Override
    public void execute(PrintWriter writer) {
        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append("Available commands: (Press Entre for next)\n");
        helpMessage.append("  deposit <amount> - Deposits <amount> into your account. (Press Entre for next)\n");
        helpMessage.append("  withdraw <amount> - Withdraws <amount> from your account. (Press Entre for next)\n");
        helpMessage.append("  transfer <amount> <toClientId> - Transfers <amount> to another account. (Press Entre for next)\n");
        helpMessage.append("  balance - Displays your current balance. (Press Entre for next)\n");
        helpMessage.append("  help - Displays this help message. (Press Entre for next)\n");
        helpMessage.append("  exit - Disconnects from the server. (Press Entre for next)");
        helpMessage.append("  This is the end of the help message. Proceed what you want.");

        writer.println(helpMessage.toString());
    }
}