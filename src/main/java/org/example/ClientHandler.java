package org.example;

import accountInfos.ClientInfos;
import state.*;

import java.io.*;
import java.net.Socket;

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
        stateCreateAccount = new StateCreateAccount(this,server);
        stateLogin = new StateLogin(this,server);
        stateLogged = new StateLogged(this);
        stateIdle = new StateIdle(this);
        stateDeposit = new StateDeposit(this,server);
        stateTransaction = new StateTransaction(this,server);
        stateConsultSolde = new StateConsultSolde(this);
        stateConsultTransactions = new StateConsultTransaction(this);
        this.currentState = stateIdle;
        System.out.println(server);
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
            while (true) {
                // If the client user types "exit", break the loop and close the connection
                if ((message = in.readLine()) != null) {
                    //Print on the serveur the message of the client
                    System.out.println("Received: " + message);
                    //The actual state handle the request and verify what shee needs to do
                    currentState.handleRequest(message);
                    //Print in which state the client is
                    sendMessage(currentState.stateInfos());
                }
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client is closing the connection.");
                    break;
                }
            }

            // Close resources
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    public State getStateDeposit() {
        return stateDeposit;
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

    public State getStateTransaction() {
        return stateTransaction;
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
    public State getStateConsultSolde() {
        return stateConsultSolde;
    }

    public State getStateConsultTransactions() {
        return stateConsultTransactions;
    }


}
