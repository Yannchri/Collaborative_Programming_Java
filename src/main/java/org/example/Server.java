package org.example;
import accountInfos.ClientInfos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {

    List<ClientInfos> listClient = new ArrayList<>();

    public void addClient(ClientInfos clientInfos){
        listClient.add(clientInfos);
    }

    public List<ClientInfos> getListClient(){
        return listClient;
    }

    public ClientInfos getClient(String number){
        for(ClientInfos clientInfos : listClient){
            // If username exists, delegate further processing to the next handler
            if(clientInfos.getNumberPhone().equals(number)){
                return clientInfos;
            }
        }
        return null;
    }

    public void start (){
        try{
            // Create a server socket that listens on port 45000
            ServerSocket serverSocket = new ServerSocket(45000);
            System.out.println("Server started and waiting for clients to connect...");

            while (true) {
                // Accept an incoming client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // Create a new thread to handle the client using AcceptClient class
                Thread clientThread = new Thread(new ClientHandler(clientSocket,this));
                clientThread.start();
                System.out.println(this);

            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }



    /*public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 45000
            ServerSocket serverSocket = new ServerSocket(45000);
            System.out.println("Server started and waiting for clients to connect...");

            while (true) {
                // Accept an incoming client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // Create a new thread to handle the client using AcceptClient class
                Thread clientThread = new Thread(new ClientHandler(clientSocket,this));
                clientThread.start();


            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur
            throw new RuntimeException(e);
        }
    }*/


}
