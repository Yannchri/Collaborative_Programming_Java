package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String Firstline;

        try {
            // Create a socket to connect to the server at IP 127.0.0.1 (localhost) and port 45000
            Socket client = new Socket("127.0.0.1", 45000);
            System.out.println("Connected to the server.");

            // Get the input stream of the socket (to read data sent by the server)
            InputStream inputStream = client.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader buffin = new BufferedReader(reader);

            // Get the output stream of the socket (to send data to the server)
            OutputStream outputStream = client.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            // Create a Scanner to read user input from the console
            Scanner sc = new Scanner(System.in);

            String firstLine = buffin.readLine();
            System.out.println("Server: " + firstLine);
            String message = sc.nextLine();
            out.println(message);
            firstLine = buffin.readLine();
            System.out.println("Server: " + firstLine);

            while (true) {
                // Prompt the client user for a message
                System.out.print("Communication to the bank >> ");
                message = sc.nextLine();

                // Send the client user's message to the server
                out.println(message);

                // If the client user types "exit", break the loop and close the connection
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client is closing the connection.");
                    break;
                }
                String line;

                while ((line = buffin.readLine()) != null) {
                    System.out.println("Server: " + line);
                    if (line.equalsIgnoreCase("Goodbye!")) {
                        client.close();
                        System.out.println("Server has disconnected.");
                        return;
                    }
                    break;
                }

            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur
            throw new RuntimeException(e);
        }
    }
}