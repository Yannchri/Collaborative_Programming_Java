package state;

import org.example.ClientHandler;

public class StateConsultSolde implements State{

    private ClientHandler clientHandler;

    public StateConsultSolde(ClientHandler clientHandler){
        this.clientHandler = clientHandler;
    }


    @Override
    public void handleRequest(String input) {
        if(input.equals("return")){
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
    public void chargeAmount() {

    }

    @Override
    public void transaction() {

    }

    @Override
    public String stateInfos() {
        return "The amount of your account is :\n" + clientHandler.getClientInfo().getClientAccount().getBalance() +
                "\nPress return to leave";
    }
}
