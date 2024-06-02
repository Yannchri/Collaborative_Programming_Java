package chainOfResponsabilities.Transaction;

import accountInfos.ClientInfos;
import org.example.Server;

import java.util.List;

public class VerifyDestinationTransactionHandler extends TransactionHandler {


    public VerifyDestinationTransactionHandler(Server server) {
        super(server);
    }

    @Override
    public String forwardTransaction(TransactionRequest transactionRequest) {
        //On vérifie que l'utilisateur de destination existe sur le serveur
        // c'est un string qui est passé
        ClientInfos receiver = server.getClient(transactionRequest.getReceiver());
            // If username exists, delegate further processing to the next handler
            if(receiver !=null){
                //If the receiver is the same than the sender
                if(receiver.getNumberPhone().equals(transactionRequest.getSender().getNumberPhone())){
                    return "You can't use this feature to transfer to yourself";
                }
                return this.transactionHandlerChain.forwardTransaction(transactionRequest);
            }

            return "This destination number doesn't exist"; // Username does not exist
        }

    }
