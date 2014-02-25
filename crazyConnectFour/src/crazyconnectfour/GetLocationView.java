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

import java.awt.Point;
import java.util.Scanner;

    
/**
 *
 * @author Crystal Coatney, Terry Wall
 */
public class GetLocationView {
    
    public Game game = new Game();
    
    public GetLocationView(Game game) {
        
        
        this.game = game;
    }
    
    /*
     * Prompt the user to enter the location (column) to place their 
     * marker on the board
     * @Param game the object representing the game
     */
    public Point getInput() {

        Scanner inFile = new Scanner(System.in); // get input file      
        String[] coordinates;
        Point location = null;
        
        boolean valid = false;
        

        // prompt the use to enter the locaton to placeread the row and column coordinates
        while (!valid) {
            // prompt for the row and column numbers
            System.out.println("\n\n\t" + this.game.currentPlayer.name + " it is your turn."
                + " Enter a column number (For example: 1)");
            
            // get the value entered by the user 
            String strRowColumn = inFile.nextLine(); 
            
            // trim off all extra blanks from the input
            strRowColumn = strRowColumn.trim();  
/*            
            // replace any commas enter with blanks
            strRowColumn = strRowColumn.replace(',', ' '); 
           
            // tokenize the string into an array of words
            coordinates = strRowColumn.split("\\s"); 

            if (coordinates.length < 1) { // the value entered was not blank?
                new CrazyConnectFourError().displayError(
                        "You must enter a number, the column, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }    

            else if (coordinates.length == 1) { // only one coordinate entered?*/
                if (strRowColumn.toUpperCase().equals("Q")) { // Quit?
                    return null;
                } 
/*                else { // wrong number of values entered.
                    new CrazyConnectFourError().displayError(
                        "You must enter one number, the column, "
                        + "or a \"Q\" to quit. Try again.");
                    continue;
                }
            }

 */           
            // user java regular expression to check for valid integer number 
            // for both numbers
            String regExpressionPattern = ".*\\d.*";
            if (!strRowColumn.matches(regExpressionPattern)) {
                new CrazyConnectFourError().displayError(
                        "You must enter one number, the number columns, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }
            
            // convert each of the cordinates from a String type to 
            // an integer type
          
            
            int column = Integer.parseInt(strRowColumn);
                     
            Board board = this.game.board; // get the game board
            
            // Check for invalid row and column entered
          
                if (column < 1  ||  column > board.columnCount) {
                new CrazyConnectFourError().displayError(
                        "Enter a valid number columns from 3 to 10. Try again.");
                continue;
            }
            
            // create a Point object to store the row and column coordinates in
            location = new Point(row-1, column-1);
            
            // check to see if the location entered is already occupied
            if ( board.boardLocations[row-1][column-1] != null ) {
                new CrazyConnectFourError().displayError(
                    "The current location is taken. Select another location");
                continue;
            }

            valid = true; // a valid location was entered

        }
        
        return location; 
            
    }

}
