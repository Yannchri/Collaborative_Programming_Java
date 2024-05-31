package accountInfos;

import accountInfos.Account;

public class Transactions {

    private String date;

    private double amount;

    private String receiver;

    private String sender;

    public Transactions(String date, double amount, String receiver,String sender){
        this.date=date;
        this.amount=amount;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getInfosTransaction(){
        return "Transaction effectuée le : " + this.date
                + "\nSur le compte de " + this.receiver
                + "\nPar le compte " + this.sender
                + "\nPour un montant de " + this.amount + "\n";

    }

}
