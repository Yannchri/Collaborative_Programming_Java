package state;

import org.example.ClientHandler;

public class StateLogged implements State{


    private ClientHandler clientHandler;

    public StateLogged(ClientHandler clientHandler){
        this.clientHandler = clientHandler;
    }

    @Override
    public void handleRequest(String input) {
        int inputValue = Integer.parseInt(input);
        switch(inputValue){
            case 1 :
                clientHandler.setState(clientHandler.getStateDeposit());
                break;
            case 2 :
                clientHandler.setState(clientHandler.getStateConsultSolde());
                break;
            case 3 :
                clientHandler.setState(clientHandler.getStateTransaction());
                break;
            case 4 :
                clientHandler.setState(clientHandler.getStateConsultTransactions());
                break;
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
        return "Deposit: 1 \nSee your sold: 2\nMake a Transaction :3 \nSee your Transaction : 4\nexit";
    }
}
