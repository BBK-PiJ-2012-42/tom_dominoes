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
public class LocalPlayer implements DominoPlayer {
    private ArrayList<Bone> playerHand = new ArrayList<>();
    private String playerName = "";
    private int playerPoints = 0;
    private Play currentPlay;
    private ConsoleControl console = new ConsoleControl();
    
    @Override
    public Play makePlay(Table table) throws CantPlayException {
        if(canPlay(table)) {
            Play newPlay = console.getPlay(this, table);
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
