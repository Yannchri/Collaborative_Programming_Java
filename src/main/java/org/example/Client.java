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
            InputStream inputStream = client.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader buffin = new BufferedReader(reader);

            // Get the output stream of the socket (to send data to the server)
            OutputStream outputStream = client.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            // Create a Scanner to read user input from the console
            Scanner sc = new Scanner(System.in);

            // Start a loop to keep the conversation going until "exit" is written
            String message;
            while (true) {
                // Prompt the client user for a message
                System.out.println("Your message:");
                message = sc.nextLine();

                // Send the client user's message to the server
                out.println(message);

                // If the client user types "exit", break the loop and close the connection
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client is closing the connection.");
                    break;
                }

                // Check and read all messages from the server
                String line;
                while (buffin.ready()) {
                    line = buffin.readLine();
                    if (line != null) {
                        // Print the received line to the console
                        System.out.println("Server: " + line);

                        // If the server sends "exit", break the loop and close the connection
                        if (line.equalsIgnoreCase("exit")) {
                            System.out.println("Server has disconnected.");
                            return;
                        }
                    }
                }
            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur
            throw new RuntimeException(e);
        }
    }
}