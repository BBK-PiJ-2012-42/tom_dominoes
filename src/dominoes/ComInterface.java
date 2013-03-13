/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author tom
 */
public interface ComInterface extends Remote {
    
    public int getPlayerCount() throws RemoteException;
    
    public String communicate(String clientName, String clientMessage) throws RemoteException;
    
    public void setServerMessage(String serverMessage) throws RemoteException;
    
    public String getClientMessage() throws RemoteException;
    
    public String getClientName() throws RemoteException;
    
    public void passRemote(RemotePlayerInter object) throws RemoteException;
    
    public RemotePlayerInter getRemote() throws RemoteException;
}

