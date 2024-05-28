package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import org.example.Command.*;

public class Accept_client implements Runnable {
    private Socket clientSocket;
    private Map<String, Account> accounts;
    private Invoker invoker;

    public Accept_client(Socket socket, Map<String, Account> accounts, Invoker invoker) {
        this.clientSocket = socket;
        this.accounts = accounts;
        this.invoker = invoker;
    }

    @Override
    public void run() {
        try (
                InputStream in = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);)
                 {

            writer.println("Enter your username:");

            String username = reader.readLine().trim();

            Account account = accounts.get(username);
            if (account == null) {
                account = new Account(username, 0.0);
                accounts.put(username, account);
            }

            writer.println("Welcome, " + username + ". Your current balance is $" + account.getBalance());

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    writer.println("Goodbye!");
                    break;
                }
                processCommand(line, writer, account);
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Failed to close client socket: " + e.getMessage());
            }
        }
    }

    private void processCommand(String line, PrintWriter writer, Account account) {
        String[] parts = line.split(" ");
        String commandName = parts[0].toLowerCase();
        Command command;

        try {
            switch (commandName) {
                case "deposit":
                    if (parts.length == 2) {
                        double amount = Double.parseDouble(parts[1]);
                        command = new DepositCommand(account, amount);
                    } else {
                        writer.println("Usage: deposit <amount>");
                        return;
                    }
                    break;
                case "withdraw":
                    if (parts.length == 2) {
                        double amount = Double.parseDouble(parts[1]);
                        command = new WithdrawCommand(account, amount);
                    } else {
                        writer.println("Usage: withdraw <amount>");
                        return;
                    }
                    break;
                case "transfer":
                    if (parts.length == 3) {
                        double amount = Double.parseDouble(parts[1]);
                        String toUsername = parts[2];
                        Account toAccount = accounts.get(toUsername);
                        if (toAccount == null) {
                            toAccount = new Account(toUsername, 0.0);
                            accounts.put(toUsername, toAccount);
                        }
                        command = new TransferCommand(account, toAccount, amount);
                    } else {
                        writer.println("Usage: transfer <amount> <toUser>");
                        return;
                    }
                    break;
                case "balance":
                    command = new BalanceCommand(account);
                    break;
                case "help":
                    command = new HelpCommand();
                    break;
                default:
                    writer.println("Unknown command: " + commandName);
                    return;
            }

            command.execute(writer);
        } catch (NumberFormatException e) {
            writer.println("Invalid amount. Please enter a valid number.");
        }
    }
}
