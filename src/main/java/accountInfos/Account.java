package accountInfos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import accountInfos.*;

/**
 * The Account class represents a bank account.
 * It contains information about the account balance and a list of transactions.
 */
public class Account {


    private double balance;

    public List<Transactions> getListTransaction() {
        return listTransaction;
    }

    // List of transactions associated with the account
    List<Transactions> listTransaction;

    /**
     * Constructs an Account object with the specified initial balance.
     *
     * @param balance The initial balance of the account.
     */
    public Account(double balance){
        this.balance = balance;
        listTransaction = new ArrayList<>();
    }

    public void chargeAmount(double amount){
        this.balance += amount;
    }

    public void diminueAmount(double amount){
        this.balance -= amount;
    }

    public void addTransaction(double amount, String sender, String receiver){
        String date = new Date().toString();
        Transactions transactions = new Transactions(date, amount,receiver,sender);
        listTransaction.add(transactions);
    }

    public double getBalance() {
        return balance;
    }

}
