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

package CIT260.PairedProgramming.CrazyConnectFour.Views;

import CIT260.PairedProgramming.CrazyConnectFour.Models.Board;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.LocationException;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.ErrorType;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Game;
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
            System.out.println("\n\n\t" + this.game.getCurrentPlayer().getName() + " it is your turn."
                + " Enter a column number (For example: 1)");
            
            // get the value entered by the user 
            String strColumn = inFile.nextLine(); 
            
            // trim off all extra blanks from the input
            strColumn = strColumn.trim();  

            
                if (strColumn.toUpperCase().equals("Q")) { // Quit?
                    return null;
                } 
                
        
            // user java regular expression to check for valid integer number 
            // for both numbers
            String regExpressionPattern = ".*\\d.*";
            try {
            if (!strColumn.matches(regExpressionPattern)) {
                throw new LocationException(ErrorType.ERROR109.getMessage());
            }
            }catch(LocationException ex){
                ErrorType.displayErrorMsg(ex.getMessage());
                }          
         
            
            // convert the column number from a String type to 
            // an integer type
            Board board = this.game.getBoard();
            int column = Integer.parseInt(strColumn);
            int row = this.game.getBoard().getRowCount();
                     
        
            
            // Check for invalid column entered
                try{
                    if (column < 1  ||  column > board.getColumnCount()) {
                        throw new LocationException(ErrorType.ERROR109.getMessage());
                    }      
                } catch (LocationException ex ){
                    ErrorType.displayErrorMsg(ex.getMessage());
                }  
            
            // create a Point object to store the row and column coordinates in
            
            
            // check to see column is already full
            while ( row > 0  && board.getBoardLocations()[row-1][column-1].getPlayer() != null ){
               row -= 1; 
            }
                try{
                    if (row != 0) {
                        valid = true;
                        location = new Point(row-1, column-1); 
                    } // a valid location was entered
                    else {
                        throw new LocationException(ErrorType.ERROR201.getMessage());
                    }
                }catch(LocationException ex){
                    ErrorType.displayErrorMsg(ex.getMessage());
                }
             }
       
        return location; 
        }     
    }

