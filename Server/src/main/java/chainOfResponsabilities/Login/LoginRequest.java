package chainOfResponsabilities.Login;

public class LoginRequest {


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
    public LoginRequest(String number, String password){
        this.number = number;
        this.password = password;
    }
}
