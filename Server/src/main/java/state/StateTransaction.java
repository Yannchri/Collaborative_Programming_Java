package state;

import chainOfResponsabilities.Transaction.TransactionChain;
import chainOfResponsabilities.Transaction.TransactionRequest;
import org.example.ClientHandler;
import org.example.Server;

public class StateTransaction implements State{

    private ClientHandler clientHandler;

    private String destination;
    private double amount;
    boolean isEnteringDestination = true;
    boolean isEnteringAmount = false;
    boolean isValidating = false;
    private Server server;
    public StateTransaction(ClientHandler clientHandler,Server server){
        this.clientHandler = clientHandler;
        this.server = server;
    }
    @Override
    public void handleRequest(String input) {
        //On vérifie s'il entre la destination
        if(isEnteringDestination){
            //il peut annuler
            if(input.equals("return")){
                clientHandler.sendMessage("Transation cancelled");
                clientHandler.setState(clientHandler.getStateLogged());
                return;
            }
            destination = input;
            isEnteringDestination = false;
            isEnteringAmount = true;
        }
        else if(isEnteringAmount){
            amount = Double.parseDouble(input);
            isEnteringAmount = false;
            isValidating = true;
        }
        else if(isValidating){
            if(input.equals(("no"))){
                clientHandler.sendMessage("Transaction cancelled");
            }else{
                TransactionRequest transactionRequest = new TransactionRequest(clientHandler.getClientInfo(),destination,amount);
                TransactionChain transactionChain = new TransactionChain(server);
                clientHandler.sendMessage(transactionChain.getRequest().forwardTransaction(transactionRequest));
            }
            isEnteringDestination = true;
            isValidating = false;
            clientHandler.setState(clientHandler.getStateLogged());
        }

    }

    @Override
    public void createAccount() {

    }

    @Override
    public void login() {

    }

    @Override
    public void transaction() {

    }


    @Override
    public String stateInfos() {
        if(isEnteringDestination){
            return "Enter the Account destination, enter return to cancel";
        }
        if(isEnteringAmount){
            return "Enter the amount that you want to transfer";
        }else{
            return "Confirm paiement ? 'yes' / 'no'";
        }
    }
}