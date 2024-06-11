package org.example;

import accountInfos.ClientInfos;
import Command.*;
import state.*;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    //All the different state
    private State currentState;
    private State stateCreateAccount;
    private State stateDeposit;
    private State stateIdle;
    private State stateLogin;
    private State stateLogged;
    private State stateTransaction;
    private Invoker invoker;
    private PrintWriter writer;


    private State stateConsultSolde;

    private State stateConsultTransactions;

    //The server référence who handle the requests
    private Server server;


    //Will be used when the user is correctly logged to know which account is logged
    private ClientInfos clientInfos;

    PrintWriter out;
    BufferedReader in;

    public ClientHandler(Socket clientSocket,Server server) throws IOException {
        this.clientSocket = clientSocket;
        this.server= server;
        this.invoker = new Invoker();
        this.writer = new PrintWriter(clientSocket.getOutputStream(), true);
        stateCreateAccount = new StateCreateAccount(this,server);
        stateLogin = new StateLogin(this,server);
        stateLogged = new StateLogged(this);
        stateIdle = new StateIdle(this);
        this.currentState = stateIdle;
        System.out.println(server);
    }

    public Invoker getInvoker() {
        return invoker;
    }


    @Override
    public void run() {
        try {
            // Get the input stream of the client socket (to read data sent by the client)
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Get the output stream of the client socket (to send data to the client)
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send initial state info to the client
            sendMessage(currentState.stateInfos());
            String message;
            while ((message = in.readLine()) != null) {
                // Print on the server the message of the client
                System.out.println("Received: " + message);

                if (message.trim().isEmpty()) {
                    //sendMessage("Invalid input: Please provide a valid command.");
                    continue;
                }

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client is closing the connection.");
                    break;
                }

                // The actual state handles the request and verifies what it needs to do
                currentState.handleRequest(message);
                // Print in which state the client is
                sendMessage(currentState.stateInfos());
            }
        } catch (SocketException e) {
            // Ignore SocketException caused by client disconnecting
            System.out.println("Client disconnected.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (clientSocket != null && !clientSocket.isClosed()) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    //All the different Getter for each State and the setter
    public void setState(State state) {
        this.currentState = state;
    }
    public State getActualState(){
        return currentState;
    }

    public State getStateCreateAccount() {
        return stateCreateAccount;
    }

    public State getStateIdle() {
        return stateIdle;
    }

    public State getStateLogin() {
        return stateLogin;
    }

    public State getStateLogged() {
        return stateLogged;
    }

    public Server getServer() {
        return server;
    }

    public ClientInfos getClientInfo() {
        return clientInfos;
    }

    public void setClientInfos(ClientInfos clientInfos) {
        this.clientInfos = clientInfos;
    }

    public PrintWriter getWriter() {
        return writer;
    }
}
