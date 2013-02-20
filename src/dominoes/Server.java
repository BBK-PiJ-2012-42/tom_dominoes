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
    private int port = 1099;
    private ComInterface connection= new ComImpl();
    
    public Server() {
        //this.connection = new ComImpl();
    }
    
    public void start(){
        try {
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("serverCom", connection);
        } catch (Exception e) {
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
