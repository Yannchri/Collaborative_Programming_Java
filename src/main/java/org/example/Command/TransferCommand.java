package org.example.Command;

import java.io.PrintWriter;

public class TransferCommand implements Command {
    private Account fromAccount;
    private Account toAccount;
    private double amount;

    public TransferCommand(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount  = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void execute(PrintWriter writer) {
        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            writer.println("Transferred $" + amount + " from " + fromAccount.getUsername() + " to " + toAccount.getUsername());
            writer.println("New balance for " + fromAccount.getUsername() + ": $" + fromAccount.getBalance());
            writer.println("New balance for " + toAccount.getUsername() + ": $" + toAccount.getBalance());
        } else {
            writer.println("Not enough funds in account " + fromAccount.getUsername() + ". Current balance: $" + fromAccount.getBalance());
        }
    }
}