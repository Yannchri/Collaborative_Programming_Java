package Command;
import accountInfos.ClientInfos;
import chainOfResponsabilities.Transaction.TransactionChain;
import chainOfResponsabilities.Transaction.TransactionRequest;
import org.example.ClientHandler;
import org.example.Server;
import state.*;

import java.io.PrintWriter;

public class TransferCommand implements Command {
    private ClientInfos fromAccount;
    private String toAccountString;
    private double amount;
    private State stateTransaction;
    private ClientHandler clientHandler;
    private Server server;

    public TransferCommand(ClientHandler clientHandler, Server server, ClientInfos fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccountString = toAccount;
        this.amount = amount;
        this.clientHandler = clientHandler;
        this.server = server;
    }

    @Override
    public void execute(PrintWriter writer) {

        TransactionChain transactionChain = new TransactionChain(server);
        stateTransaction = new StateTransaction(clientHandler,server);
        TransactionRequest transactionRequest = new TransactionRequest(fromAccount,toAccountString,amount);
        String message = transactionChain.getRequest().forwardTransaction(transactionRequest);

        clientHandler.sendMessage(message);
    }
}