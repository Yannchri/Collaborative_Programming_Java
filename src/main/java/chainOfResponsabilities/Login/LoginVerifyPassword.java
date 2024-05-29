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
        List<ClientInfos> clientList = server.getListCLient();
        // Iterate through the list of clients to find a match
        for (ClientInfos client : clientList) {
            if (client.getNumberPhone().equals(loginRequest.getNumber())) {
                if (client.getPassword().equals(loginRequest.getPassword())) {
                    return client; // Login credentials are correct return the client
                }
            }
        }
        return null; // Login credentials are incorrect
    }
}
