package state;

import org.example.ClientHandler;

/**
 * The StateIdle class represents the idle state in the state machine pattern.
 * This state handles the initial actions that a client can take, such as creating an account or logging in.
 */
public class StateIdle implements State{

    private ClientHandler clientHandler;

    /**
     * Constructs a new StateIdle with the specified client handler.
     *
     * @param clientHandler The ClientHandler instance managing the state transitions.
     */
    public StateIdle(ClientHandler clientHandler){
        this.clientHandler = clientHandler;
    }

    /**
     * Handles a request based on the input provided.
     * Transitions to the appropriate state based on the input.
     *
     * @param input The input string to process.
     */
    @Override
    public void handleRequest(String input) {
        int numberToInt = Integer.parseInt(input);
        /*If the client enter 1, go to the menu to create an account
        If the client enter 2, go to the menu for login */
        switch(numberToInt){
            case 1 :
                clientHandler.setState(clientHandler.getStateCreateAccount());
                break;
            case 2 :
                clientHandler.setState(clientHandler.getStateLogin());
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

    /**
     * Provides information about the current state.
     *
     * @return A string containing state-specific information.
     */
    @Override
    public String  stateInfos() {
        return "Welcome !\nCreate an account : 1 \nConnect : 2 \nexit";
    }
}
