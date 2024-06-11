package chainOfResponsabilities.Credential;

import org.example.Server;

/**
 * Abstract class CredentialHandler serves as a base class for handling credentials verification.
 * It implements the Chain of Responsibility pattern to allow multiple verification steps for
 * creating accounts and logging in.
 */
public abstract class CreateHandler {

    // Next handler in the chain
    protected CreateHandler credentialHandlerChain;
    // Reference to the server
    protected Server server;
    /**
     * Constructs a CredentialHandler with a reference to the server.
     *
     * @param server The Server instance containing the list of clients.
     */
    public CreateHandler(Server server) {
        this.server = server;
    }

    /**
     * Sets the next handler in the verification chain.
     *
     * @param nextchain The next CredentialHandler in the chain.
     */
    public void setNextVerification(CreateHandler nextchain){
        this.credentialHandlerChain = nextchain;
    }

    /**
     * Abstract method to verify the credentials for creating an account.
     * Subclasses must implement this method to define their specific verification logic.
     *
     * @param creationRequest The request containing the credentials for account creation.
     * @return A string indicating the result of the verification.
     */
    public abstract String forwardCreateAccount(CreateRequest creationRequest);


}
