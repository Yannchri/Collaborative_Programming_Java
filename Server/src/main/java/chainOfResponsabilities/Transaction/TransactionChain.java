package chainOfResponsabilities.Transaction;

import org.example.Server;

public class TransactionChain {

    private final  TransactionHandler request;

    public TransactionChain(Server server){
        this.request = new VerifyDestinationTransactionHandler(server);
        VerifyAmountTransactionHandler verifyAmountTransactionHandler = new VerifyAmountTransactionHandler(server);
        request.setNextVerification(verifyAmountTransactionHandler);
    }

    public TransactionHandler getRequest(){
        return this.request;
    }
}
