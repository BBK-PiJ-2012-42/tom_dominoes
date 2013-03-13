/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.DominoPlayer;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author tom
 */
public interface RemotePlayerInter extends Remote {
    
    public String communicate(String clientMessage) throws RemoteException;
    
    public UIControl getUIControl() throws RemoteException;
    
    public Play makePlay(Table table) throws CantPlayException, RemoteException;
    
    public void takeBack(Bone bone) throws RemoteException;
    
    public void draw(BoneYard boneyard) throws RemoteException;
            
    public int numInHand() throws RemoteException;
    
    public Bone[] bonesInHand() throws RemoteException;
    
    public void newRound() throws RemoteException;
    
    public void setPoints(int points) throws RemoteException;
    
    public int getPoints() throws RemoteException;
    
    public void setName(String name) throws RemoteException;
    
    public String getName() throws RemoteException;
    
}
