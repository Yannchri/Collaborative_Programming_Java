package state;

import chainOfResponsabilities.Credential.CreateChain;
import chainOfResponsabilities.Credential.CreateRequest;
import chainOfResponsabilities.Login.LoginChain;
import chainOfResponsabilities.Login.LoginRequest;
import org.example.ClientHandler;
import org.example.Server;

/**
 * StateLogin represents the state where the user is prompted to enter their login credentials.
 * This state handles the transition between entering the username and entering the password.
 */
public class StateLogin implements State {

    private ClientHandler clientHandler;
    private String username;
    private String password;
    private boolean isEnteringUsername = true;

    private Server server;

    /**
     * Constructs a StateLogin object with the given ClientHandler and Server references.
     *
     * @param clientHandler The ClientHandler associated with this state.
     * @param server        The Server instance used for credential verification.
     */
    public StateLogin(ClientHandler clientHandler, Server server) {
        this.clientHandler = clientHandler;
        this.server = server;
    }

    /**
     * Handles user input during the login process.
     * If the user is entering the username, it stores the username.
     * If the user is entering the password, it verifies the credentials.
     *
     * @param input The user input.
     */
    @Override
    public void handleRequest(String input) {
        //Leave the login page
        if (isEnteringUsername) {
            if (input.equals("3")) {
                clientHandler.setState(clientHandler.getStateIdle());
                return;
            }
            username = input;
            isEnteringUsername = false;
        } else {
            password = input;
            // Verify the credential with the chain of responsabilities
            LoginRequest loginRequest = new LoginRequest(username, password);
            LoginChain chain = new LoginChain(server);
            //If the chain return true, the username and password match and it's logged
            if(chain.getRequest().forwardNextVerification(loginRequest)!=null){
                clientHandler.sendMessage("Login Successfull");
                clientHandler.setState(clientHandler.getStateLogged());

                //Set up the ClientInfo of the logged for future transaction
                clientHandler.setClientInfos(chain.getRequest().forwardNextVerification(loginRequest));
            }else{
                clientHandler.sendMessage("Username or password incorrect");
            }
            isEnteringUsername = true;
        }
    }

    @Override
    public void createAccount() {
        // Implementation for creating an account
    }

    @Override
    public void login() {
        // Implementation for login
    }

    @Override
    public void chargeAmount() {
        // Implementation for charging amount
    }

    @Override
    public void transaction() {
        // Implementation for transaction
    }

    @Override
    public String stateInfos() {
        if (isEnteringUsername) {
            return "Please enter your username:";
        } else {
            return "Please enter your password:";
        }
    }
}
