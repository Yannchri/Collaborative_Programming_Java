package state;
/**
 * Interface representing different states in a state machine pattern.
 * Each state can handle specific requests and transitions.
 */
public interface State {

     /**
     * Handles a request based on the input provided.
     *
     * @param input The input string to process.
     */
     void handleRequest(String input);

     void createAccount();
     void login();

     void chargeAmount();

     void transaction();
     /**
      * Provides information about the current state.
      *
      * @return A string containing state-specific information for the client.
      */
     String stateInfos();
}
