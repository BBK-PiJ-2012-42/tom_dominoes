/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author tom
 */
public class Server {
    private int port = 80;
    private ComInterface connection = new ComImpl();
    
    public Server() throws RemoteException {
    }
    
    public void start(){
        try {
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("reg", connection);
        } catch (Exception e) {
            System.out.println(e);
        }      
        System.out.println("Server Ready");
    }
    
    public void setServerMessage(String serverMessage) throws RemoteException {
        connection.setServerMessage(serverMessage);
    }
    
    public String getClientMessage() throws RemoteException {
        return connection.getClientMessage();
    }
    
}
