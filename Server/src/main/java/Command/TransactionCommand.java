package Command;
import accountInfos.ClientInfos;
import accountInfos.Transactions;

import java.io.PrintWriter;
import java.util.List;

// Command for depositing money into an account
public class TransactionCommand implements Command {
    private ClientInfos account;


    public TransactionCommand(ClientInfos account) {
        this.account = account;

    }

    @Override
    public void execute(PrintWriter writer) {
        String message="";
        List<Transactions> listTransaction = account.getClientAccount().getListTransaction();
        for (Transactions transactions : listTransaction){
            if (transactions.getType() == "Transaction" || transactions.getType() == "Deposit"){
                message += transactions.getInfosTransaction();
            }
        }

        writer.println(message);
    }
}
