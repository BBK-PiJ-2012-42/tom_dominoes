/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.DominoPlayer;
import dominoes.players.LocalPlayer;

/**
 *
 * @author tom
 */
public class Launch {
    public static void main(String[] args) {
        Launch.begin();
    }
    
    public static void begin() {
        DominoPlayer playerOne = new LocalPlayer();
        playerOne.setName("Jim");
        DominoPlayer playerTwo = new LocalPlayer();
        playerTwo.setName("Ben");
        DominoUI gameUI = new ConsoleUI();
        Dominoes game = new Dominoes(gameUI, playerOne, playerTwo, 30, 6);
        game.play();
    }
}
