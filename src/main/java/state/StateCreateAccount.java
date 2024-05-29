package state;

import chainOfResponsabilities.Credential.CreateChain;
import chainOfResponsabilities.Credential.CreateRequest;
import org.example.ClientHandler;
import org.example.Server;

/**
 * The StateCreateAccount class represents the state in which a user is creating a new account.
 * It handles the input for creating a new account, including username (phone number) and password.
 */
public class StateCreateAccount implements State{

    private ClientHandler clientHandler;
    private Server server;  // Reference to the server

    private String username;
    private String password;
    private boolean isEnteringUsername = true;

    /**
     * Constructs a new StateCreateAccount with the specified client handler and server.
     *
     * @param clientHandler The ClientHandler instance managing the state transitions.
     * @param server The Server instance containing the list of clients.
     */
    public StateCreateAccount (ClientHandler clientHandler,Server server){
        this.clientHandler = clientHandler;
        this.server = server;
    }

    /**
     * Handles a request based on the input provided.
     * Manages the process of creating an account, including collecting username and password.
     *
     * @param input The input string to process.
     */
    @Override
    public void handleRequest(String input) {
        //If the client is on the step to enter username, it will not display the same message
        //See the method stateinfo()
        if (isEnteringUsername) {
            //If the client press return
            if (input.equals("3")) {
                clientHandler.setState(clientHandler.getStateIdle());
                return;
            }
            username = input;
            isEnteringUsername = false;
        } else {
            password = input;
            //Create the request to do some verification with Chain Of Responsabilities
            //Verify is the username is already taken
            //Verify if the password is blank
            CreateRequest request = new CreateRequest(username, password);
            CreateChain chain = new CreateChain(server); // Pass the server to the chain
            //Return the String and create the user
            clientHandler.sendMessage(chain.getRequest().forwardCreateAccount(request));
            isEnteringUsername = true;
            clientHandler.setState(clientHandler.getStateIdle());

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
     * Depending on the step of the account creation process, it prompts for the appropriate input.
     *
     * @return A string containing state-specific information.
     */
    @Override
    public String stateInfos() {
        if(isEnteringUsername){
            return "Please enter your phone number  \nPress '3' to cancel";
        }else{
            return "Please enter your password";
        }

    }
}
