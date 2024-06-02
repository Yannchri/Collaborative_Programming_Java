package Command;
import accountInfos.ClientInfos;

import java.io.PrintWriter;

// Command for depositing money into an account
public class DepositCommand implements Command {
    private ClientInfos account;
    private double amount;

    public DepositCommand(ClientInfos account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute(PrintWriter writer) {
        account.getClientAccount().chargeAmount(amount);
        writer.println("Deposited: $" + amount + ". New Balance: $" + account.getClientAccount().getBalance());
    }
}
