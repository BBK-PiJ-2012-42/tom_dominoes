package dominoes;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author tom
 */
public class Client {
    private ComInterface connection = null;
    private String ipAddress = "127.0.0.1";
    private int port = 1099;
    
    public Client() {
        
    }
    
//    public boolean connect() {
//        try {
//            Registry myRegistry = LocateRegistry.getRegistry(ipAddress, port);
//            connection = (ComInterface) myRegistry.lookup("serverCom");
//            return true;
//       } catch (Exception e) {
//           return false;
//        }  
//    }
    
    public String sendMessage(String ClientMessage) throws RemoteException {
        try {
            Registry myRegistry = LocateRegistry.getRegistry(ipAddress, port);
            connection = (ComInterface) myRegistry.lookup("serverCom");
            String response = connection.communicate(ClientMessage);
            if(response != null) {
                return response;
            } else {
                return "no response.";
            }
        } catch (Exception e) {
                return "Error.";
            }  
    }
    
}
