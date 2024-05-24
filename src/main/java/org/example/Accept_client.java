package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Accept_client implements Runnable {
    private Socket clientSocket;

    public Accept_client(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Get the input stream of the client socket (to read data sent by the client)
            InputStream inputStream = clientSocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader buffin = new BufferedReader(reader);

            // Get the output stream of the client socket (to send data to the client)
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            // Create a Scanner to read user input from the console
            Scanner sc = new Scanner(System.in);

            // Start a loop to keep the conversation going until "exit" is written
            String message = "Hello, Welcome to jungle";
            out.println(message);
            while (true) {
                // Prompt the client user for a message

                // Send the client user's message to the server


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
            // Close resources
            buffin.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            // Handle any IO exceptions that occur
            throw new RuntimeException(e);
        }
    }
}