/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author tom
 */
public class ComImpl extends UnicastRemoteObject implements ComInterface {
    private String serverMessage = null;
    private String clientMessage = null;
    
    public ComImpl() throws RemoteException {
        
    }

    @Override
    public String communicate(String clientMessage) throws RemoteException {
        this.clientMessage = clientMessage;
        return serverMessage;
    }

    @Override
    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    @Override
    public String getClientMessage() {
        return clientMessage;
    }
    
    
    
}
