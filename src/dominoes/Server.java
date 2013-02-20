/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author tom
 */
public class Server {
    private int port = 80;
    private ComInterface connection = new ComImpl();
    
    public Server() {
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
    
    public void setServerMessage(String serverMessage) {
        connection.setServerMessage(serverMessage);
    }
    
    public String getClientMessage() {
        return connection.getClientMessage();
    }
    
}
