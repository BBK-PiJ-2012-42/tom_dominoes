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
    public String name;
    
    public Client() {
        this.name = Double.toString(Math.random() * 10);
    }
    
    
    public String sendMessage(String clientMessage) throws RemoteException {
        try {
            Registry myRegistry = LocateRegistry.getRegistry(ipAddress, port);
            connection = (ComInterface) myRegistry.lookup("reg");
            String response = connection.communicate(name, clientMessage);
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
