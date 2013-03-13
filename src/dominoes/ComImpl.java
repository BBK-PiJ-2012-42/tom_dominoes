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
    private String clientName = "";
    private RemotePlayerInter object;
    private int playerCount = 0;
    
    public ComImpl() throws RemoteException {
        
    }
    
    @Override
    public int getPlayerCount() {
        if(playerCount > 0) {
            System.out.println("Returning player count of "+playerCount);
        }
        return playerCount;
    }

    @Override
    public String communicate(String clientName, String clientMessage) throws RemoteException {
        this.clientName = clientName;
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
    
    @Override
    public String getClientName() {
        return clientName;
    }

    @Override
    public void passRemote(RemotePlayerInter object) throws RemoteException {
        this.object = object;
        playerCount++;
    }

    @Override
    public RemotePlayerInter getRemote() throws RemoteException {
        return object;
    }
    
    
    
    
    
}
