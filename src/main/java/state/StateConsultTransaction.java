package state;

import accountInfos.Transactions;
import org.example.ClientHandler;

import java.util.List;

public class StateConsultTransaction  implements State{

    private ClientHandler clientHandler;
    public StateConsultTransaction(ClientHandler clientHandler){
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
        String message="";
        List<Transactions> listTransaction = clientHandler.getClientInfo().getClientAccount().getListTransaction();
        for (Transactions transactions : listTransaction){
            message += transactions.getInfosTransaction();
        }
        message += "Press return to leave";
        return message;
    }
}
