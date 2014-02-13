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
 * @author dccoatney Terry Wall
 */

   public class GetPlayerNameView {
    Game game = new Game();
    Player player = new Player();
    
    public GetPlayerNameView(Game game) {
        this.game = game;
        
    }

    /**
     *
     * @return
     */
    
    public String getInput() {

        String newName = null;
        Scanner in = new Scanner(System.in);
                
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("\n\t" 
                    + ", Enter a player name with a minimum of 3 characters and a maximum of 12 charcters.You can also enter Q to quit.");
            
            // get input from user           
            newName = in.nextLine();
           
            // no Name entered?
            if (newName == null  || newName.length() < 1) {
                continue;
            }
            
            //convert name to uppercaase
            newName = newName.toUpperCase();
            
            if (newName.equals("Q")) { // Quit?
                return null;
            }
            
            // Check to see if name is between 3 and 12 charcters. 
            if (newName.length() < 3) {
               new CrazyConnectFourError().displayError(
                        "The name needs to have atleast three characters. Try again");
               continue; 
            }
            
            if (newName.length() > 12) {
               new CrazyConnectFourError().displayError(
                        "The name needs to have no more than twelve characters. Try again");
               continue; 
            }
            
            valid = true; // signal that a valid token was entered
        }
        
        return newName;
    }
    
}
 
    