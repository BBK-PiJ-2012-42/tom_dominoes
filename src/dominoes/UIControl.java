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
public abstract interface UIControl {
    
    public Play getPlay(DominoPlayer player, Table table);
    
    public void updateInvalid(DominoPlayer player);
    
    public void updateWinner(DominoPlayer player);
    
    public void updatePlayer(DominoPlayer player);
    
    public void updateTable(Table table);
    
    public void updateBoneyard(BoneYard boneyard);
    
    
            
            
            
            
    
}
