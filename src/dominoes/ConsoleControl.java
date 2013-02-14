/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoes;

import dominoes.players.DominoPlayer;
import java.util.Scanner;

/**
 *
 * @author tom
 * 
 * Used to send text to the console and control input.
 * The ConsoleUI uses it to send output to the players while the LocalPlayer
 * class uses the getPlay method to get user input.
 * 
 */
public class ConsoleControl implements UIControl {
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public Play getPlay(DominoPlayer player, Table table) {
        System.out.println("The table looks like this at the moment:");
        updateTable(table);
        System.out.println("So you can play "+table.left()+" : "+table.right());
        System.out.println(player.getName()+" you have the following options. Please pick one.");
        printOptions(player);
        int option = 100;
        do{
            option = getInt();
        } while(option >= player.numInHand());
        println("Now which side? 0 for left or 1 for right: ");
        int sideInt = getInt();
        if(sideInt == 0) {
            return new Play(player.bonesInHand()[option], Play.LEFT);
        } else {
            return new Play(player.bonesInHand()[option], Play.RIGHT);
        }
        
    }
    
    @Override
    public void updateInvalid(DominoPlayer player) {
        System.out.print("Sorry "+player.getName()+" that is not a valid play!");
    }
    
    @Override
    public void updateWinner(DominoPlayer player) {
        System.out.println("And the winner is: "+player.getName()+"!");

        
    }
    
    @Override
    public void updatePlayer(DominoPlayer player) {
        Bone[] hand = player.bonesInHand();
        System.out.print("Player "+player.getName()+" Score: "+player.getPoints()+" Bones: "+player.numInHand());
        System.out.print("\n ");
    }
    
    @Override
    public void updateTable(Table table) {
        Bone[] layout = table.layout();
        System.out.print("Table: ");
        for(Bone eachBone : layout) {
            printBone(eachBone);
            System.out.print(" ");
        }
        System.out.print("\n ");
    }
    
    @Override
    public void updateBoneyard(BoneYard boneyard) {
        System.out.println("Boneyard Size: "+boneyard.size());
    }
    
    private void printBone(Bone bone) {
        System.out.print("["+bone.left()+","+bone.right()+"]");
    }
    
    private void println(String output) {
        System.out.println(output);
    }
    
    private String getString() {
        return input.nextLine();   
    }
    
    private int getInt() {
        return input.nextInt();  
    }
    
    private void printOptions(DominoPlayer player) {
        Bone[] hand = player.bonesInHand();
        int option = 0;
        for(Bone eachBone : hand) {
            System.out.print(" "+option+": ");
            printBone(eachBone);
            option++;
        } 
        System.out.print("\n ");
    }
    

       
}
