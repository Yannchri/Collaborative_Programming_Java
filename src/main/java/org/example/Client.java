package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server at IP 127.0.0.1 (localhost) and port 45000
            Socket client = new Socket("127.0.0.1", 45000);
            System.out.println("Connected to the server.");

            // Get the input stream of the socket (to read data sent by the server)
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // Get the output stream of the socket (to send data to the server)
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Create a Scanner to read user input from the console
            Scanner sc = new Scanner(System.in);

            /*I have split in 2 Thread 1 for listening 1 for sending
            At the beggining i Had a lot of problem when i tried with 1 Thread
             */

            // Thread for reading messages from the server
            Thread readThread = new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println("Server: " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readThread.start();

            // Main thread for sending messages to the server
            String message;
            // Start a loop to keep the conversation going until "exit" is written
            while (true) {
                //System.out.print("Your message: ");
                message = sc.nextLine();
                out.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client is closing the connection.");
                    break;
                }
            }
            // Wait for the reading thread to finish
            readThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}