/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author tom
 */
public interface ComInterface extends Remote {
    public String communicate(String clientMessage) throws RemoteException;
    
    public void setServerMessage(String serverMessage) throws RemoteException;
    
    public String getClientMessage() throws RemoteException;
}

