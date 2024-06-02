package chainOfResponsabilities.Login;

import accountInfos.ClientInfos;
import org.example.Server;

import java.util.List;

public class LoginVerifyPassword extends LoginHandler{


    public LoginVerifyPassword(Server server) {
        super(server);
    }

    @Override
    public ClientInfos forwardNextVerification(LoginRequest loginRequest) {

        ClientInfos clientInfos = server.getClient(loginRequest.getNumber());
        //If the password is equal to the request
        if (clientInfos.getPassword().equals(loginRequest.getPassword())) {
            return clientInfos; // Login credentials are correct return the client
        }
        return null; // Login credentials are incorrect
    }
}
