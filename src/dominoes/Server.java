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
    
    private void start(){
        try {
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("serverCom", new ComImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }      
        System.out.println("Server Ready");
    }
    
}
