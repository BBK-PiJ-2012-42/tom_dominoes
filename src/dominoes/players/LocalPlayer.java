/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes.players;

import dominoes.*;
import java.util.ArrayList;

/**
 *
 * @author tom
 */
public abstract class LocalPlayer implements DominoPlayer {
    ArrayList<Bone> playerHand = new ArrayList<>();
    String playerName = "";
    int playerPoints = 0;
    
    @Override
    public Play makePlay(Table table) throws CantPlayException {
        int i = 0;
        Play newPlay = new Play(null, i);
        return newPlay;
    }
    
    @Override
    public void takeBack(Bone bone) {
         // ?
    }
    
    @Override
    public void draw(BoneYard boneyard) {
        Bone newBone = boneyard.draw();
        if(newBone != null) {
            playerHand.add(newBone);
        }
    }
    
    @Override
    public int numInHand() {
        return playerHand.size();
    }
    
    @Override
    public Bone[] bonesInHand() {
        return (Bone[]) playerHand.toArray();
    }
    
    @Override
    public void newRound() {
        playerHand.clear();
    }
    
    @Override
    public void setPoints(int points) {
        playerPoints = points;
    }
    
    @Override
    public int getPoints() {
        return playerPoints;
    }
    
    @Override
    public void setName(String name) {
        playerName = name;
    }
    
    @Override
    public String getName() {
        return playerName;
    }
    
}
