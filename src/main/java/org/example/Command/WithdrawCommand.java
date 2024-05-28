package org.example.Command;

import java.io.PrintWriter;

public class WithdrawCommand implements Command {
    private Account account;
    private double amount;

    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute(PrintWriter writer) {
        if (account.getBalance() >= amount) {
            account.withdraw(amount);
            writer.println("Withdrew $" + amount + ". New balance: $" + account.getBalance());
        } else {
            writer.println("Insufficient funds for withdrawal. Current balance: $" + account.getBalance());
        }
    }
}