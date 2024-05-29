package chainOfResponsabilities.Login;

import accountInfos.ClientInfos;
import org.example.Server;

public abstract class LoginHandler {

    protected LoginHandler loginHandlerChain;

    protected Server server;


    public LoginHandler(Server server){
        this.server = server;
    }

    public void setNextVerification(LoginHandler nextverification){
        this.loginHandlerChain = nextverification;
    }

    public abstract ClientInfos forwardNextVerification(LoginRequest loginRequest);
}
