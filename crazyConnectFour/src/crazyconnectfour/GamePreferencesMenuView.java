/*
 * The MIT License
 *
 * Copyright 2014 dccoatney.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/*author Crystal Coatney*/

package crazyconnectfour;

import java.util.Scanner;


public class GamePreferencesMenuView {
    
    Game game;
    private GamePreferencesMenuControl gamePreferenceControl;

    private final static String[][] menuItems = {
        {"1", "Change Token of the first Player"},
        {"2", "Change Token of the second Player"},
        {"D", "Change the dimensions of the board"},
        {"Q", "Return to game menu"}
   
    };

    
 public GamePreferencesMenuView(Game game) {
     
        this.game = game;
        gamePreferenceControl = new GamePreferencesMenuControl(game);
 }
 
    public void getInput() {       
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display();

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            
            
            
            
            switch (command) {
                case "1":
                    this.gamePreferenceControl.getToken(this.game.playerA);
                    System.out.println("\n\t Player 1 is using "+ this.game.playerA.token +" as a token");
                    System.out.println("\n\t Player 2 is using "+ this.game.playerB.token +" as a token");
                    break;
                case "2":
                    this.gamePreferenceControl.getToken(this.game.playerB);
                    System.out.println("\n\t Player 1 is using "+ this.game.playerA.token +" as a token");
                    System.out.println("\n\t Player 2 is using "+ this.game.playerB.token +" as a token");
                    break;
                case "D":
                    this.gamePreferenceControl.getDimensions();
                    break;
                case "Q":
                    break;
                default: 
                    new CrazyConnectFourError().displayError("Invalid command. Please enter a valid command.");
                    continue;
            }
        } while (!command.equals("Q"));

        return;
    }
    
    
        
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < GamePreferencesMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
 
}


