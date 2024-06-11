package Command;

import accountInfos.ClientInfos;

import java.io.PrintWriter;

public class BalanceCommand implements Command {
    private ClientInfos account;

    public BalanceCommand(ClientInfos account) {
        this.account = account;
    }

    @Override
    public void execute(PrintWriter writer) {
        writer.println("Current Balance: $" + account.getClientAccount().getBalance());
    }
}
