package chainOfResponsabilities.Credential;

/**
 * The CredentialRequest class represents a request containing user credentials.
 * This class is used to pass credentials (phone number and password) for account
 * creation and login verification in the Chain of Responsibility pattern.
 */
public class CreateRequest {


    private String number;

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    private String password;
    /**
     * Constructs a CredentialRequest with the specified phone number and password.
     *
     * @param number   The user's phone number.
     * @param password The user's password.
     */
    public CreateRequest(String number, String password){
        this.number = number;
        this.password = password;
    }

}
