package chainOfResponsabilities.Login;

import org.example.Server;

public class LoginChain {


    private final LoginHandler request;

    public LoginChain(Server server){
        this.request = new LoginVerifyNumber(server);
        LoginHandler verifyPassword = new LoginVerifyPassword(server);
        this.request.setNextVerification(verifyPassword);
    }


    public LoginHandler getRequest(){
        return  request;
    }
}
