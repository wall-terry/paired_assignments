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

package crazyconnectfour;

import java.util.Scanner;

/**
 *
 * @author dccoatney, Terry Wallimport java.util.Scanner;

*/

public class GetTokenView {
    Game game = new Game();
    Player player = new Player();
    
    private final static String[][] tokenOptions = {
        {"R", "RED"},
        {"B", "BLACK"},
        {"G", "GREEN"},
        {"Y", "YELLOW"},
        {"P", "PINK"},
        {"O", "ORANGE"},
        {"Q", "QUIT"}
    };
    
    
    public GetTokenView(Game game) {
        this.game = game;
        
    }

    /**
     *
     * @param player
     * @return
     */
    
    public String getInput(Player player) {

        String newToken = null;
        Scanner in = new Scanner(System.in);
           
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("\n\t" + player.name);
            this.display();
            
            // get input from user           
            newToken = in.nextLine();
           
            // no token entered?
            if (newToken == null  || newToken.length() < 1) {
                continue;
            }
            
            // grab only the first character and convert it to upper case
            newToken = newToken.toUpperCase();
            
            if (newToken.equals("Q")) { // Quit?
                return null;
            }
           int i = 0;
           boolean breakout = false;
           do{
          
                if(newToken.equals(tokenOptions[i][0])) {
                    newToken = tokenOptions [i][1];
                    breakout = true;
                   }
                i++;

                
            } while (tokenOptions.length != i && !breakout) ;
           
            if (i == tokenOptions.length){
                new CrazyConnectFourError().displayError("\n\t Invalid Entry Try Again");
                continue;
            }
            
            // Check to see if the token is already in use
            if (this.game.playerA.token.equals(newToken) ||
                this.game.playerB.token.equals(newToken) ) {
               new CrazyConnectFourError().displayError(
                        "This token is currently in use. " +
                        "Select a different token");
               continue; 
            }
            
            valid = true; // signal that a valid token was entered
        }
        
        return newToken;
    }

    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following Token Options:");

        for (int i = 0; i < GetTokenView.tokenOptions.length; i++) {
            System.out.println("\t   " + tokenOptions[i][0] + "\t" + tokenOptions[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
}
 
    
