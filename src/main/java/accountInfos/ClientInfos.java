package accountInfos;
/**
 * The ClientInfos class represents the information of a client.
 * It contains the client's phone number, password, and account details.
 */
public class ClientInfos {



    private String numberPhone;
    private String password;
    private String salt;

    private Account clientAccount;

    /**
     * Constructs a ClientInfos object with the specified phone number, password, and account details.
     *
     * @param numberPhone   The phone number of the client.
     * @param password      The password of the client.
     * @param clientAccount The account details of the client.
     */
    public ClientInfos(String numberPhone, String password, Account clientAccount){
        this.numberPhone = numberPhone;
        this.password = password;
        this.clientAccount = clientAccount;
    }

    //Different setter and Getter
    public String getNumberPhone() {
        return numberPhone;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public Account getClientAccount() {
        return clientAccount;
    }
}
