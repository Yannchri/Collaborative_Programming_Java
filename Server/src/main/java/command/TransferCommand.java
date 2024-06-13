package command;

import accountInfos.ClientInfos;
import chainOfResponsabilities.Transaction.TransactionChain;
import chainOfResponsabilities.Transaction.TransactionRequest;
import org.example.ClientHandler;
import org.example.Server;

import java.io.PrintWriter;

// command for transferring money between accounts
public class TransferCommand implements Command {
    private ClientInfos fromAccount; // Sender's account
    private String toAccountString; // Receiver's account (as a string)
    private double amount; // Amount to transfer
    private ClientHandler clientHandler; // Client handler
    private Server server; // Server

    // Constructor
    public TransferCommand(ClientHandler clientHandler, Server server, ClientInfos fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccountString = toAccount;
        this.amount = amount;
        this.clientHandler = clientHandler;
        this.server = server;
    }

    // Execution of transfer command
    @Override
    public void execute(PrintWriter writer) {
        // Creating a transaction request
        TransactionRequest transactionRequest = new TransactionRequest(fromAccount, toAccountString, amount);
        // Creating a transaction chain
        TransactionChain transactionChain = new TransactionChain(server);
        // Forwarding the transaction request
        String message = transactionChain.getRequest().forwardTransaction(transactionRequest);
        // Sending the message to the client handler
        clientHandler.sendMessage(message);
    }
}
