/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes.players;

import dominoes.*;

/**
 *
 * @author tom
 */
public abstract class LocalPlayer implements DominoPlayer {
    
    
    @Override
    public Play makePlay(Table table) throws CantPlayException {
        int i = 0;
        Play newPlay = new Play(null, i);
        return newPlay;
    }
    
    @Override
    public void takeBack(Bone bone) {
         
    }
    
    public void draw(BoneYard boneyard) {
        
    }
    
    @Override
    public int numInHand() {
        
    }
    
}
