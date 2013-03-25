/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes.players;

import dominoes.Bone;
import dominoes.BoneYard;
import dominoes.CantPlayException;
import dominoes.Play;
import dominoes.Table;
import dominoes.UIControl;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author T
 */
public class RandomAIPlayer implements DominoPlayer {
    private ArrayList<Bone> playerHand = new ArrayList<Bone>();
    private String playerName = "";
    private int playerPoints = 0;
    private Bone playBone = new Bone(-1, -1);
    private Play newPlay = new Play(playBone, Play.RIGHT);
    private ArrayList<Play> possiblePlays;

    public RandomAIPlayer(String name, UIControl control) {
        this.playerName = name;
    }
    
    @Override
    public Play makePlay(Table table) throws CantPlayException {
        if(canPlay(table)) {
            possiblePlays = getPotentialPlays(table);
            // Initalise playScore to the correct length.
            int noOfPlays = possiblePlays.size();
            
            Random randGen = new Random();
            int randomSelect = randGen.nextInt(noOfPlays);
            newPlay = possiblePlays.get(randomSelect);
            //showPlayScores();
            removeBone(newPlay.bone());
            return newPlay;
        } else {
            throw new CantPlayException();
        }
    }
    
    
    
    private ArrayList<Play> getPotentialPlays(Table table) {
        // Clear possiblePlays of last rounds options.
        possiblePlays = new ArrayList<Play>();
        for(Bone eachBone : playerHand) {
            if(eachBone.left() == table.left() | eachBone.right() == table.left()) {
                possiblePlays.add(new Play(eachBone, Play.LEFT));
            } else if (eachBone.left() == table.right() | eachBone.right() == table.right()) {
                possiblePlays.add(new Play(eachBone, Play.RIGHT));
            }
        }
        return possiblePlays;
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
