package chainOfResponsabilities.Transaction;

import accountInfos.Account;
import accountInfos.ClientInfos;

public class TransactionRequest {



    private String receiver;
    private ClientInfos sender;
    private double amount;

    public TransactionRequest(ClientInfos sender, String receiver, double amount){
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }


    public String getReceiver() {
        return receiver;
    }

    public ClientInfos getSender() {
        return sender;
    }

    public double getAmount() {
        return amount;
    }

}
