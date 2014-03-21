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

import CrazyConnectFourExceptions.CrazyConnectFourError;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Game;
import java.awt.Dimension;
import java.util.Scanner;

/**
 *
 * @author Terry Wall, Crystal Coatney
 */


public class GetDimensionsView {
    
    private Game game;
    
    public GetDimensionsView(Game game) {
       this.game = game;
    }
        
    public Dimension getInput() {
       Scanner inFile = new Scanner(System.in);

       // prompt for the row and column numbers
       System.out.println("\n\tEnter the number of rows and columns in the board (For example: 3 3)");

       // read the row and column coordinates
       String[] valuesEntered;
       Dimension dimension = null;
       do {
           String strNoRowsColumns = inFile.nextLine(); // read in row and column
           strNoRowsColumns = strNoRowsColumns.trim(); // trim all blanks from front and end 
           strNoRowsColumns = strNoRowsColumns.replace(',', ' '); // replace commas with a blank
           valuesEntered = strNoRowsColumns.split("\\s"); // tokenize the string

           if (valuesEntered.length < 1) {
               new CrazyConnectFourError().displayError(
                       "You must enter two numbers, the number rows and columns, "
                       + "or a \"Q\" to quit. Try again.");
               continue;
           } else if (valuesEntered.length == 1) {
               if (valuesEntered[0].toUpperCase().equals("Q")) { // Quit?
                   return null;
               }  // wrong number of values entered.

               // wrong number of values entered.
               new CrazyConnectFourError().displayError(
                      "You must enter two numbers, the number rows and columns, "
                      + "or a \"Q\" to quit. Try again.");
               continue;
           }

           // user java regular expression to check for valid integer number 
           // for both numbers
           String regExpressionPattern = ".*\\d.*";
           if (!valuesEntered[0].matches(regExpressionPattern) ||
               !valuesEntered[1].matches(regExpressionPattern)) {
               new CrazyConnectFourError().displayError(
                       "You must enter two numbers, the number rows and columns, "
                       + "or a \"Q\" to quit. Try again.");
               continue;
           }

           int rowsEntered = Integer.parseInt(valuesEntered[0]);
           int columnsEntered = Integer.parseInt(valuesEntered[1]);

           if (rowsEntered < 6 || rowsEntered > 15) {
           new CrazyConnectFourError().displayError(
                   "The number of rows must be between 6 -15 and the "
                   + "number of columns must be between 6 -15 ");
           continue;
           }

           if (columnsEntered < 6 || columnsEntered > 15) {
               new CrazyConnectFourError().displayError(
                       "The number of rows must be between 6 -15 and the "
                       + "number of columns must be between 6 -15 ");
               continue;
           }



           dimension = new Dimension(rowsEntered, columnsEntered);

       } while (dimension == null);



       return dimension;
    }
    
}
