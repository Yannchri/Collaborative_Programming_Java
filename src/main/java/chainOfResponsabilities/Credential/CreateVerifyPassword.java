package chainOfResponsabilities.Credential;

import accountInfos.Account;
import accountInfos.ClientInfos;
import org.example.Server;

import java.util.List;

/**
 * The VerifyPasswordCredentialHandler class is responsible for verifying the
 * password in the chain of responsibility. It checks if the password meets
 * the required criteria during account creation and verifies the password
 * during login.
 */
public class CreateVerifyPassword extends CreateHandler {

    // List of clients retrieved from the server
    List<ClientInfos> clientList = server.getListCLient();

    /**
     * Constructs a VerifyPasswordCredentialHandler with the specified server.
     * Initializes the handler with a reference to the server.
     *
     * @param server The server instance containing client information for verification.
     */
    public CreateVerifyPassword(Server server) {
        super(server);
    }

    /**
     * Verifies the password during account creation.
     * If the password is valid, it creates a new client account and adds it to the server.
     *
     * @param creationRequest The request containing the number and password for account creation.
     * @return A string message indicating the result of the account creation process.
     */
    @Override
    public String forwardCreateAccount(CreateRequest creationRequest) {
        if (creationRequest.getPassword() == null) {
            return "Password cannot be blank";
        }
        // Create a new account with a default balance of 0
        Account clientAccount = new Account(0);

        // Get the number and password from the creation request
        String numberPhone = creationRequest.getNumber();
        String password = creationRequest.getPassword();

        // Add the new client information to the server's client list
        server.addClient(new ClientInfos(numberPhone, password, clientAccount));

        // Return a success message
        return "User created with success";
    }

}
