/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.DominoPlayer;
import dominoes.players.LocalPlayer;
import dominoes.players.SimpleAIPlayer;

/**
 *
 * @author tom
 */
public class Launch {
    public static void main(String[] args) {
        Launch.begin();
    }
    
    public static void begin() {
        UIControl control = new ConsoleControl();
//        if(control.askGameType == UIControl.LOCAL) {
//            
//        }
        DominoPlayer playerOne = new LocalPlayer("Jim", control);
        DominoPlayer playerTwo = new SimpleAIPlayer("MARVIN", control);
        DominoUI gameUI = new ConsoleUI(control);
        Dominoes game = new Dominoes(gameUI, playerOne, playerTwo, 20, 6);
        game.play();
    }
}
