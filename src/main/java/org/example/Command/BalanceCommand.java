package org.example.Command;

import java.io.PrintWriter;

public class BalanceCommand implements Command {
    private Account account;

    public BalanceCommand(Account account) {
        this.account = account;
    }

    @Override
    public void execute(PrintWriter writer) {
        writer.println("Current Balance: $" + account.getBalance());
    }
}
