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
public class SimpleAIPlayer implements DominoPlayer {
    private ArrayList<Bone> playerHand = new ArrayList<>();
    private String playerName = "";
    private int playerPoints = 0;
    //private Play currentPlay;
    private UIControl control;
    
    public SimpleAIPlayer(String name, UIControl control) {
        this.playerName = name;
        this.control = control;
    }
    
    @Override
    public Play makePlay(Table table) throws CantPlayException {
        if(canPlay(table)) {
            ArrayList<Bone> playableBones = new ArrayList<>();
            Bone playBone = new Bone(-1, -1);
            Play newPlay = new Play(playBone, Play.RIGHT);
            for(Bone eachBone : playerHand) {
                if(eachBone.left() == table.left() | eachBone.right() == table.left()) {
                    if((eachBone.left() + eachBone.right()) > (playBone.left() + playBone.right())) {
                        playBone = eachBone;
                        newPlay = new Play(eachBone, Play.LEFT);
                    }
                } else if (eachBone.left() == table.right() | eachBone.right() == table.right()) {
                    if((eachBone.left() + eachBone.right()) > (playBone.left() + playBone.right())) {
                        playBone = eachBone;
                        newPlay = new Play(eachBone, Play.RIGHT);
                    }
                }                
            }     
            removeBone(newPlay.bone());
            return newPlay;
        } else {
            throw new CantPlayException();
        }
    }
    
    @Override
    public void takeBack(Bone bone) {
        playerHand.add(bone);
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
        Bone[] boneArray = playerHand.toArray(new Bone[playerHand.size()]);
        return boneArray;
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
    
    private boolean canPlay(Table table) {
        for(Bone eachBone : playerHand) {
            if(eachBone.left() == table.left() || eachBone.left() == table.right()) {
                return true;
            } else if(eachBone.right() == table.left() || eachBone.right() == table.right()) {
                return true;
            }
        }
        return false;
    }
    
    private void removeBone(Bone bone) {
        playerHand.remove(bone);
    }
}
