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

        ClientInfos clientInfos = server.getClient(loginRequest.getNumber());
        //If client exist we can continue the verifications
        if(clientInfos!=null){
            return this.loginHandlerChain.forwardNextVerification(loginRequest);
        }
        return null; // Username does not exist
    }
}
