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
 * @author terry wall
 */
public class BoardView {
    
    Board board;
    
    public void displayBoard(Object object) {
        this.board = (Board) object;
        this.printHeadRow();
        this.printDividerRow();
        for (int i = 0; i < this.board.getRowCount(); i++) {
            Player[] rowOfLocations = this.board.getBoardLocations()[i];
            this.printRow(i+1, rowOfLocations);
            this.printDividerRow();
        }
        System.out.println();
         
/*        return null;*/
    }

    private void printHeadRow() {

        // print first cell

        System.out.print("\n\t      1    ");
        int columnsInRow = this.board.getColumnCount();
        // print remaining cells in row
        for (int i = 1; i < columnsInRow - 1; i++) {
            int col = i + 1;
            System.out.print("   " + col + "   ");
        }
        System.out.print("  " + columnsInRow + "   ");
    }

    private void printDividerRow() {

        // print first cell

        System.out.print("\n\t  |-------");
        int columnsInRow = this.board.getColumnCount();
        // print remaining cells in row
        for (int i = 1; i < columnsInRow - 1; i++) {
            System.out.print("-------");
        }
        System.out.print("------|");
    }

    private void printRow(int rowNumber, Player[] rowLocations) {
        
        // print first cell
        String letter = "      ";
        if (rowLocations[0] != null) {
            letter = rowLocations[0].token;
        }
        System.out.print("\n\n\t" + rowNumber + " |" + letter + "|");

        // print remaining cells in row
        for (int i = 1; i < rowLocations.length; i++) {
            if (rowLocations[i] == null) {
                letter = "      ";
            } else {
                letter = rowLocations[i].token;
            }
            System.out.print("" + letter + "|");
        }
        System.out.print("\n");
    }

}
