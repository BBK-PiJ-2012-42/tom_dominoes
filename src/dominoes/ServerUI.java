/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.DominoPlayer;
import java.rmi.RemoteException;

/**
 *
 * @author tom
 */
public class ServerUI implements DominoUI {
    private DominoPlayer playerOne;
    private DominoPlayer playerTwo;
    private UIControl controlOne;
    private UIControl controlTwo;
    
    public ServerUI(RemotePlayerInter playerOne, RemotePlayerInter playerTwo) throws RemoteException {
        this.playerOne = (DominoPlayer) playerOne;
        this.playerTwo = (DominoPlayer) playerTwo;
        this.controlOne = playerOne.getUIControl();
        this.controlTwo = playerTwo.getUIControl();
    }
    
    
    //private ConsoleControl console = new ConsoleControl();
    
    @Override
    public void display(DominoPlayer players[], Table table, BoneYard boneyard) {
        controlOne.updatePlayer(playerOne); 
        controlOne.updateTable(table);
        controlOne.updateBoneyard(boneyard);
        controlTwo.updatePlayer(playerTwo); 
        controlTwo.updateTable(table);
        controlTwo.updateBoneyard(boneyard);
    }
    
    @Override
    public void displayRoundWinner(DominoPlayer player) {
        controlOne.updateWinner(player);
        controlTwo.updateWinner(player);
    }
    
    @Override
    public void displayInvalidPlay(DominoPlayer player) {
        controlOne.updateInvalid(player);
        controlTwo.updateInvalid(player);
    }
    
}
