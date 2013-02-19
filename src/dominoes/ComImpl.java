/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import java.rmi.RemoteException;

/**
 *
 * @author tom
 */
public class ComImpl implements ComInterface {
    private String serverMessage = null;
    private String clientMessage = null;

    @Override
    public String communicate(String clientMessage) throws RemoteException {
        this.clientMessage = clientMessage;
        return serverMessage;
    }

    @Override
    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
    
}
