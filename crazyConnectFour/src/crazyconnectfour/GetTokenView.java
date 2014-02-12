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

/**
 *
 * @author dccoatney, Terry Wallimport java.util.Scanner;

*/

public class GetTokenView {
    public GetTokenView ) {
        this.game = game;
}
public String getInput(Player player) {

        String newMarker = null;
        Scanner in = new Scanner(System.in);
                
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("\n\t" + player.name 
                    + ", enter a single character that will be used to mark "
                    + "your squares in the game.");
            
            // get input from user           
            newMarker = in.nextLine();
           
            // no marker entered?
            if (newMarker == null  || newMarker.length() < 1) {
                continue;
            }
            
            // grab only the first character and convert it to upper case
            newMarker = newMarker.substring(0, 1).toUpperCase();
            
            if (newMarker.equals("Q")) { // Quit?
                return null;
            }
            
            // Check to see if the marker is already in use
            if (this.game.playerA.marker.equals(newMarker) ||
                this.game.playerB.marker.equals(newMarker) ) {
               new CrazyConnectFourError().displayError(
                        "This marker is currently in use. " +
                        "Select a different character");
               continue; 
            }
            
            valid = true; // signal that a valid marker was entered
        }
        
        return newMarker;
    }
    
}
 */
public class GetTokenView {
    
}
