package chainOfResponsabilities.Transaction;

import accountInfos.ClientInfos;
import org.example.Server;

public class VerifyAmountTransactionHandler extends  TransactionHandler{



    public VerifyAmountTransactionHandler(Server server) {
        super(server);
    }

    @Override
    public String forwardTransaction(TransactionRequest transactionRequest) {
        //Grab the different info to create the transaction
        ClientInfos sender = transactionRequest.getSender();
        //Maybe modify the TransactionRequest and take a second InfoClient and not a string in parameter for the receiver
        ClientInfos receiver = server.getClient(transactionRequest.getReceiver());
        double amount = transactionRequest.getAmount();

        if(sender.getClientAccount().getBalance() - amount <0){
            return "Not enough money on your account";
        }else{
            //Take the money of the sender
            sender.getClientAccount().diminueAmount(amount);
            //Create the transaction of the sender account
            sender.getClientAccount().addTransaction(amount,sender.getNumberPhone(), receiver.getNumberPhone());
            //Increase the money of the receiver
            receiver.getClientAccount().chargeAmount("", amount);
            //Create the transaction
            receiver.getClientAccount().addTransaction(amount, sender.getNumberPhone(), receiver.getNumberPhone());

            return "Transaction successfull";
        }
    }

}
