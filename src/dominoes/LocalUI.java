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
public class LocalUI implements DominoUI {
    ConsoleControl console = new ConsoleControl();
    
    @Override
    public void display(DominoPlayer players[], Table table, BoneYard boneyard) {
        console.printPlayer(players[0]); 
        console.printTable(table);
        console.printBoneyard(boneyard);
    }
    
    @Override
    public void displayRoundWinner(DominoPlayer player) {
        console.printWinner(player);
    }
    
    @Override
    public void displayInvalidPlay(DominoPlayer player) {
        console.printInvalid(player);
    }
    
}
