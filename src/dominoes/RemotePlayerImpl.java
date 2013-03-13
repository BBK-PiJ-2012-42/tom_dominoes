/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.DominoPlayer;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author tom
 */
public class RemotePlayerImpl implements RemotePlayerInter, DominoPlayer   {  
    private DominoPlayer player;
    private UIControl control;
    
    public RemotePlayerImpl(DominoPlayer player, UIControl control) {
        this.player = player;
        this.control = control;
    }
    
    @Override
    public UIControl getUIControl() throws RemoteException {
        return control;
    }

    @Override
    public String communicate(String clientMessage) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Play makePlay(Table table) throws CantPlayException, RemoteException {
        return player.makePlay(table);
    }
    
    @Override
    public void takeBack(Bone bone) throws RemoteException {
        player.takeBack(bone);
    }
    
    @Override
    public void draw(BoneYard boneyard) throws RemoteException {
        player.draw(boneyard);
    }
    
    @Override
    public int numInHand() throws RemoteException {
        return player.numInHand();
    }
    
    @Override
    public Bone[] bonesInHand() throws RemoteException {
        return player.bonesInHand();
    }
    
    @Override
    public void newRound() throws RemoteException {
        player.newRound();
    }
    
    @Override
    public void setPoints(int points) throws RemoteException {
        player.setPoints(points);
    }
    
    @Override
    public int getPoints() throws RemoteException {
        return player.getPoints();
    }
    
    @Override
    public void setName(String name) {
        player.setName(name);
    }
    
    @Override
    public String getName() {
        return player.getName();
    }

}
