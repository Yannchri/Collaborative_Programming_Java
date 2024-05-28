package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import org.example.Command.*;

public class Server {
    private static final int PORT = 45000;
    private static ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
    private static Invoker invoker = new Invoker();

    public static void main(String[] args) {
        setupCommands();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new Accept_client(clientSocket, accounts, invoker)).start();
                System.out.println("New client connected");
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void setupCommands() {
        invoker.registerCommand("help", new HelpCommand());
        // Note: No need to create accounts here, they will be created on client connection
    }
}
