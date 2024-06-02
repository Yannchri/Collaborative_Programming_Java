package Command;
import accountInfos.ClientInfos;
import chainOfResponsabilities.Transaction.TransactionChain;
import chainOfResponsabilities.Transaction.TransactionRequest;
import chainOfResponsabilities.Transaction.VerifyAmountTransactionHandler;
import chainOfResponsabilities.Transaction.VerifyDestinationTransactionHandler;
import org.example.ClientHandler;
import org.example.Server;
import state.State;
import state.StateTransaction;

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


//        if (fromAccount.getClientAccount().getBalance() >= amount) {
//            fromAccount.getClientAccount().diminueAmount(amount);
//            toAccount.getClientAccount().chargeAmount(amount);
//            writer.println("Transferred $" + amount + " from " + fromAccount.getNumberPhone() + " to " + toAccount.getNumberPhone());
//            writer.println("New balance for " + fromAccount.getNumberPhone() + ": $" + fromAccount.getClientAccount().getBalance());
//            //writer.println("New balance for " + toAccount.getNumberPhone() + ": $" + toAccount.getClientAccount().getBalance());
//        } else {
//            writer.println("Not enough funds in account " + fromAccount.getNumberPhone() + ". Current balance: $" + fromAccount.getClientAccount().getBalance());
//        }
    }
}