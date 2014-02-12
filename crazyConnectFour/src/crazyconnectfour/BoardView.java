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

/**
 *
 * @author dccoatney
 */
     package crazyconnectfour;

/**
 *
 * @author jacksonrkj
 */
public class BoardView {
    
    Board board;
    
    public Object displayBoard(Object object) {
          this.board = board;
        
        this.printHeadRow(); // print the header row for the board
        this.printDividerRow(); // print the top divider row of the board
        
        // for all rows in the board
        for (int i = 0; i < this.board.rowCount; i++) {
            // get the list of list of columns locations in the row
            Location[] rowOfLocations = this.board.boardLocations[i];
            
            // print the contents of each location in the row
            this.printRow(i+1, rowOfLocations); 
            
            this.printDividerRow();// print the ending divider for the row
        }
        
        System.out.println(); // print blank line after the board
         
        return;
    }

    private void printHeadRow() {

        // print the first column in the header row
        System.out.print("\n\t      1   ");
        
        // print remaining header cells in row between the first and last column
        int columnsInRow = this.board.columnCount;
        for (int i = 1; i < columnsInRow - 1; i++) {
            int col = i + 1;
            System.out.print("  " + col + "   ");
        }
        // print the header for the last column in the header
        System.out.print(" " + columnsInRow + "   ");
    }

    private void printDividerRow() {

        // print the divider for the first column in the row
        System.out.print("\n\t  |------");
        
        int columnsInRow = this.board.columnCount;
        // print remaining divider for each column between the first and last
        for (int i = 1; i < columnsInRow - 1; i++) {
            System.out.print("------");
        }
        // print the row divider for the last column in the row
        System.out.print("-----|");
    }

    private void printRow(int rowNumber, Location[] rowLocations) {
        
        // print contents of first column in the row
        String letter = " ";
        if (rowLocations[0].player != null) {
            letter = rowLocations[0].player.marker;
        }
        System.out.print("\n\t" + rowNumber + " |  " + letter + "  |");

        // print the contents of the rest of the columns in the row 
        for (int i = 1; i < rowLocations.length; i++) {
            if (rowLocations[i].player == null) {
                letter = " ";
            } else {
                letter = rowLocations[i].player.marker;
            }
         
            System.out.print("  " + letter + "  |");
        }
    }

}




