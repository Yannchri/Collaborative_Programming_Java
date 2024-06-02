package chainOfResponsabilities.Credential;
import accountInfos.ClientInfos;
import org.example.Server;

import java.util.List;

/**
 * The VerifyUsernameCredentialHandler class is responsible for verifying the
 * uniqueness of the username (phone number) in the chain of responsibility.
 * It checks if the username is already taken during account creation and
 * delegates further processing to the next handler if the username is available.
 */
public class CreateVerifyNumber extends CreateHandler {

    // List of clients retrieved from the server
    List<ClientInfos> clientList = server.getListClient();

    /**
     * Constructs a VerifyUsernameCredentialHandler with the specified server.
     * Initializes the handler with a reference to the server.
     *
     * @param server The server instance containing client information for verification.
     */
    public CreateVerifyNumber(Server server) {
        super(server);
    }

    /**
     * Verifies the uniqueness of the username (phone number) during account creation.
     * If the username already exists, it returns an error message.
     * Otherwise, it delegates further processing to the next handler in the chain.
     *
     * @param creationRequest The request containing the number and password for account creation.
     * @return A string message indicating the result of the username verification process.
     */
    @Override
    public String forwardCreateAccount(CreateRequest creationRequest) {
        // Iterate through the list of clients to check if the username already exists
        for (ClientInfos client : clientList) {
            if (client.getNumberPhone().equals(creationRequest.getNumber())) {
                return "Username already Exist";  // Username already exists
            }
        }
        return this.credentialHandlerChain.forwardCreateAccount(creationRequest);  // Username is available go to check password
    }

}
