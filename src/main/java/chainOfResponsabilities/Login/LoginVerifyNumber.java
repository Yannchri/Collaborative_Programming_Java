package chainOfResponsabilities.Login;

import accountInfos.ClientInfos;
import org.example.Server;

import java.util.List;

public class LoginVerifyNumber extends LoginHandler{
    public LoginVerifyNumber(Server server) {
        super(server);
    }

    @Override
    public ClientInfos forwardNextVerification(LoginRequest loginRequest) {
        List<ClientInfos> clientList = server.getListCLient();
        for(ClientInfos clientInfos : clientList){
            // If username exists, delegate further processing to the next handler
            if(clientInfos.getNumberPhone().equals(loginRequest.getNumber())){
                return this.loginHandlerChain.forwardNextVerification(loginRequest);
            }
        }
        return null; // Username does not exist
    }
}
