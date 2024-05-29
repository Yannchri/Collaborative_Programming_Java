package chainOfResponsabilities.Transaction;

import org.example.Server;

public abstract class TransactionHandler {

    protected TransactionHandler transactionHandlerChain;

    protected Server server;

    public TransactionHandler(Server server){
        this.server = server;
    }

    public void setNextVerification(TransactionHandler nextVerification){
        this.transactionHandlerChain = nextVerification;
    }

    public abstract String forwardTransaction(TransactionRequest transactionRequest);


}
