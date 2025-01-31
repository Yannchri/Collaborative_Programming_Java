package state;

import command.*;
import accountInfos.ClientInfos;
import org.example.ClientHandler;

public class StateLogged implements State{


    private ClientHandler clientHandler;

    public StateLogged(ClientHandler clientHandler){
        this.clientHandler = clientHandler;
    }

    @Override
    public void handleRequest(String input) {
        String[] parts = input.split(" ");
        String commandName = parts[0];
        switch (commandName) {
            case "deposit":
                if (parts.length == 2) {
                    double amount = Double.parseDouble(parts[1]);
                    clientHandler.getInvoker().registerCommand("deposit", new DepositCommand(clientHandler.getClientInfo(), amount));
                    clientHandler.getInvoker().executeCommand("deposit", clientHandler.getWriter());
                } else {
                    clientHandler.getWriter().println("Invalid command. Usage: deposit <amount>");
                }
                break;
            case "transfer":
                if (parts.length == 3) {
                    double amount = Double.parseDouble(parts[1]);
                    ClientInfos currentClient = clientHandler.getClientInfo();
                    String toClientId = parts[2];
                    ClientInfos toAccount = clientHandler.getClientInfo();
                    if (toAccount != null) {
                        clientHandler.getInvoker().registerCommand("transfer", new TransferCommand(clientHandler, clientHandler.getServer(), currentClient,toClientId, amount));
                        clientHandler.getInvoker().executeCommand("transfer", clientHandler.getWriter());
                    } else {
                        clientHandler.getWriter().println("Invalid client ID for transfer.");
                    }
                } else {
                    clientHandler.getWriter().println("Invalid command. Usage: transfer <amount> <toClientId>");
                }
                break;
            case "transaction":
                clientHandler.getInvoker().registerCommand("transaction", new TransactionCommand(clientHandler.getClientInfo()));
                clientHandler.getInvoker().executeCommand("transaction", clientHandler.getWriter());
                break;
            case "balance":
                clientHandler.getInvoker().registerCommand("balance", new BalanceCommand(clientHandler.getClientInfo()));
                clientHandler.getInvoker().executeCommand("balance", clientHandler.getWriter());
                break;
            case "help":
                clientHandler.getInvoker().registerCommand("help", new HelpCommand());
                clientHandler.getInvoker().executeCommand("help", clientHandler.getWriter());
                break;
            case "exit":
                clientHandler.getWriter().println("Exiting...");
                System.exit(0);
                break;
            default:
                clientHandler.getWriter().println("Unknown command. Type 'help' for a list of commands.");
        }
    }

    @Override
    public void createAccount() {

    }

    @Override
    public void login() {

    }


    @Override
    public void transaction() {

    }

    @Override
    public String stateInfos() {
        return "What would you like to do next? Choose an option or type 'help' for guidance.";
    }


}

