package accountInfos;

import accountInfos.Account;

public class Transactions {

    private String date;

    private double amount;

    private String receiver;

    private String sender;

    private String type;

    public Transactions(String type, String date, double amount, String receiver,String sender){
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getType() {
        return type;
    }

    public String getInfosTransaction(){
        return "Transaction : "
                + "\nType of transaction : " + this.type
                + "\nDate : " + this.date
                + "\nOn the account : " + this.receiver
                + "\nFrom the account : " + this.sender
                + "\nAmount : " + this.amount + "\n_______________\n";

    }

}
