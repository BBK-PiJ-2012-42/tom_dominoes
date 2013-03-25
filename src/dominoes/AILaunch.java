/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.RuleBaseAIPlayer;
import dominoes.players.DominoPlayer;
import dominoes.players.RandomAIPlayer;
import dominoes.players.SimpleAIPlayer;

/**
 *
 * @author tom
 */
public class AILaunch {
    public static void main(String[] args) {
        AILaunch.begin();
    }
    
    public static void begin() {
        UIControl control = new ConsoleControl();
        DominoPlayer playerOne = new RuleBaseAIPlayer("HAL", control);
        //DominoPlayer playerOne = new SimpleAIPlayer("Jim", control);
        //DominoPlayer playerTwo = new SimpleAIPlayer("MARVIN", control);
        DominoPlayer playerTwo = new RandomAIPlayer("MARVIN", control);
        DominoUI gameUI = new ConsoleUI(control);
        Dominoes game = new Dominoes(gameUI, playerOne, playerTwo, 300000000, 6);
        game.play();
    }
}
