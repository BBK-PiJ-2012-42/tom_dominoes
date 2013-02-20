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
    private String ipAddress = "0.0.0.0";
    private int port = 80;
    
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
    
    public String sendMessage(String clientMessage) throws RemoteException {
        try {
            Registry myRegistry = LocateRegistry.getRegistry(ipAddress, port);
            connection = (ComInterface) myRegistry.lookup("reg");
            String response = connection.communicate(clientMessage);
            if(response != null) {
                return response;
            } else {
                return "no response.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }  
    }
    
}
