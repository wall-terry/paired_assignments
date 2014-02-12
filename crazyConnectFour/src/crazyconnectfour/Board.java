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

/**
 *
 * @author Crystal Coatney, Terry Wall
 */
public class Board {

    public int rowCount = 8;
    public int columnCount = 8;
   
    public Location[][] boardLocations;

    public Board() {
    }

    public Board(int noRows, int noColumns) {
  
        this.createBoardLocations(noRows, noColumns);
    }


    public void createBoardLocations(int noRows, int noColumns) {
        this.rowCount= noRows;
        this.columnCount= noColumns;
        
        // add locations to the board
        this.boardLocations = new Location[noRows][noColumns];
        for (int row = 0; row < noRows; row++) { // for every row
            // for every column in the row
            for (int column = 0; column < noColumns; column++) { 
                this.boardLocations[row][column] = new Location();           
            }            
        }   
    }
    
    
    public void clearTheBoard() {
        // add locations to the board
        for (int row = 0; row < this.rowCount; row++) {
            for (int column = 0; column < this.columnCount; column++) {
                Location location = this.boardLocations[row][column];
                location.player = null;           
            }            
        }    
    }

    public void occupyLocation(Player player, int row, int column) {
        Location location = this.boardLocations[row][column];
        
        if ( location.player != null) { // location already occupied
            new CrazyConnectFourError().displayError("This location is already occupied. "
                    + "Try a different location.");
        }
        
        location.player = player;
    }


}
