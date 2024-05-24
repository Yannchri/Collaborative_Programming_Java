package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 45000
            ServerSocket serverSocket = new ServerSocket(45000);
            System.out.println("Server started and waiting for clients to connect...");

            while (true) {
                // Accept an incoming client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // Create a new thread to handle the client using AcceptClient class
                Thread clientThread = new Thread(new Accept_client(clientSocket));
                clientThread.start();


            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur
            throw new RuntimeException(e);
        }
    }


}
