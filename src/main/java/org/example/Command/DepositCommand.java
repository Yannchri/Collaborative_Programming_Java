package org.example.Command;

import java.io.PrintWriter;

// Command for depositing money into an account
public class DepositCommand implements Command {
    private Account account;
    private double amount;

    public DepositCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute(PrintWriter writer) {
        account.deposit(amount);
        writer.println("Deposited: $" + amount + ". New Balance: $" + account.getBalance());
    }
}
