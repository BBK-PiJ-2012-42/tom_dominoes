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
    private UIControl control;
    private String playerOneName = "";
    private String playerTwoName = "";
    private int playerOneWins = 0;
    private int playerTwoWins = 0;
    
    public ConsoleUI(UIControl control) {
        this.control = control;
    }
    
    @Override
    public void display(DominoPlayer players[], Table table, BoneYard boneyard) {
        //control.updatePlayer(players[0]); 
        //control.updatePlayer(players[1]);
        //control.updateTable(table);
        //control.updateBoneyard(boneyard);
    }
    
    @Override
    public void displayRoundWinner(DominoPlayer player) {
        control.updateWinner(player);     
        if(player != null) {

            
            if(player.getName() == "HAL") {
                playerOneWins += 1;
            } else if(player.getName() == "MARVIN") {
                playerTwoWins += 1;
            }
        }
        
        float ratio = 0;
        float percent = 0;
        
        if(playerTwoWins != 0) {
            ratio = ((float) playerOneWins) / playerTwoWins;
            percent = ((float) playerOneWins) / (playerOneWins + playerTwoWins);
        }
        
        System.out.print("HAL has won "+playerOneWins+" times. ");
        System.out.println("MARVIN has won "+playerTwoWins+" times. ");
        System.out.print("Percentage: "+percent+"% ");
        System.out.println("Ratio: "+ratio);
    }
    
    @Override
    public void displayInvalidPlay(DominoPlayer player) {
        control.updateInvalid(player);
    }
    
}
