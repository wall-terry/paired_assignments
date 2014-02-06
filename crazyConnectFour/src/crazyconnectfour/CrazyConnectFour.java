/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crazyconnectfour;

import java.util.Scanner;

/**
 *
 * @author Terry Wall
 */
public class CrazyConnectFour {
    // Instance variables
    String name;
    String instructions = "This is a modified version of the game connect four \n\n"
            + "You try to get four tokens in a row either up-and-down, left-to-right, or diagonally. \n"
            + "The added twist is once you have four in a row the tokens disappear and the tokens above them \n"
            + "drop to fill in the space.  This will likely result in new combinations of four or more which will also \n"
            + "disappear and result in a similar cascade which will continue until no more combinations of four or more \n"
            + "are created.";
    
    
    
       
    
    public static void main(String[] args) {
        boolean result;
        String Outmessage;
         ScoreBoard runningScore = new ScoreBoard();
       
        CrazyConnectFour playTheGame = new CrazyConnectFour();
        
        
        runningScore.scoreArray[0] = 0;
        runningScore.scoreArray[1] = 0;
        
        playTheGame.getName();
        playTheGame.displayHelp();
        
        result = runningScore.addScore(4, 1);
        if (result){
            Outmessage = "Score update was successful";
            System.out.println(Outmessage);
        }
        result = runningScore.addScore(5, 0);
        if (result){
            Outmessage = "Score update was successful";
            System.out.println(Outmessage);
        }
        result = runningScore.addScore(8, 1);
        if (result){
            Outmessage = "Score update was successful";
            System.out.println(Outmessage);
        }
        
    }
    
    public void getName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name:");
        this.name = input.next();
        
    }
    
    public void displayHelp(){
        System.out.println("\nWelcome " + this.name +"\n ");
        System.out.println(this.instructions);
    }

    void displayError(String invalid_command_Please_enter_a_valid_comm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
