package state;

import accountInfos.ClientInfos;
import org.example.ClientHandler;
import org.example.Server;

import java.util.List;

public class StateDeposit implements State{

    private ClientHandler clientHandler;

    public StateDeposit(ClientHandler clientHandler, Server server){
        this.clientHandler = clientHandler;
    }
    @Override
    public void handleRequest(String input) {
        if(input.equals("return")){
            clientHandler.setState(clientHandler.getStateLogged());
        }else{
            //We can probably extract this class in a method
            //Waiting to know who, maybe we need to use it again in an other class

            //Grab the clientInfos of the client who deposit
            ClientInfos clientInfos = clientHandler.getClientInfo();

            //Convert the input to double
            double inputToDouble = Double.parseDouble(input);
            clientInfos.getClientAccount().chargeAmount(inputToDouble);
            System.out.println(clientInfos.getClientAccount().getBalance());
            //Send a message to the server
            clientHandler.sendMessage("Transaction successful");
            }
        }

    @Override
    public void createAccount() {

    }

    @Override
    public void login() {

    }

    @Override
    public void chargeAmount() {

    }

    @Override
    public void transaction() {

    }


    @Override
    public String stateInfos() {
        return "Enter the amount that you want to deposit\nPress return to cancel";

    }
}
