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
        UIControl control = new ConsoleControl();
        DominoPlayer playerOne = new LocalPlayer("Jim", control);
        DominoPlayer playerTwo = new LocalPlayer("Ben", control);
        DominoUI gameUI = new ConsoleUI(control);
        Dominoes game = new Dominoes(gameUI, playerOne, playerTwo, 10, 6);
        game.play();
    }
}
