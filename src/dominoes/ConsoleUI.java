/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.DominoPlayer;



/**
 *
 * @author tom
 */
public class ConsoleUI implements DominoUI {
    UIControl control;
    int displaywinner = 0;
    
    public ConsoleUI(UIControl control) {
        this.control = control;
    }
    
    
    //private ConsoleControl console = new ConsoleControl();
    
    @Override
    public void display(DominoPlayer players[], Table table, BoneYard boneyard) {
        control.updatePlayer(players[0]); 
        control.updatePlayer(players[1]);
        control.updateTable(table);
        control.updateBoneyard(boneyard);
    }
    
    @Override
    public void displayRoundWinner(DominoPlayer player) {
        control.updateWinner(player);        
    }
    
    @Override
    public void displayInvalidPlay(DominoPlayer player) {
        control.updateInvalid(player);
    }
    
}
