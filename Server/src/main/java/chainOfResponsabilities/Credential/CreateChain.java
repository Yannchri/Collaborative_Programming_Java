package chainOfResponsabilities.Credential;

import org.example.Server;

/**
 * The CredentialChain class sets up a chain of responsibility for handling
 * credential verification. It initializes the chain with various handlers
 * that check different aspects of the credentials.
 */
public class CreateChain {



    // The initial handler in the chain of responsibility
    private final CreateHandler request;


    /**
     * Constructs a CredentialChain with the specified server.
     * Initializes the chain with the handlers for verifying the username and password.
     *
     * @param server The server instance containing client information for verification.
     */
    public CreateChain(Server server){
        // Initialize the first handler in the chain
        this.request = new CreateVerifyNumber(server);

        // Create the next handler in the chain
        CreateHandler verifyPassword = new CreateVerifyPassword(server);

        // Set the next handler in the chain
        this.request.setNextVerification(verifyPassword);
    }

    /**
     * Returns the initial handler in the chain of responsibility.
     *
     * @return The initial CredentialHandler in the chain.
     */
    //Used in the different State to know which Handler need to be call
    public CreateHandler getRequest() {
        return request;
    }

}
