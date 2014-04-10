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

package CIT260.PairedProgramming.CrazyConnectFour.Models;

import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.CrazyConnectFourError;
import java.awt.Point;
import javax.swing.table.AbstractTableModel;
import java.io.Serializable;

/**
 *
 * @author Crystal Coatney, Terry Wall
 */
public class Board extends AbstractTableModel implements Serializable {
    private int rowCount = 8;
    private int columnCount = 8;
    private Point boardDimensions = new Point();
    private Location[][] boardLocations;

    public Board() {
        if(this.getRowCount() == 0 || this.getColumnCount() == 0){
        this.boardDimensions.setLocation(rowCount,columnCount);
        this.boardLocations = new Location[rowCount][columnCount];
        }
    }

    public Board(int noRows, int noColumns) {
        this.boardDimensions.setLocation(noRows, noColumns);
        this.boardLocations = new Location[noRows][noColumns];
    }

    public Point getBoardDimensions() {
        return boardDimensions;
    }

    public void setBoardDimensions(Point boardDimensions) {
        this.boardDimensions = boardDimensions;
    }

    public Location[][] getBoardLocations() {
        return boardLocations;
    }

    public void setBoardLocations(Location[][] boardLocations) {
        this.boardLocations = boardLocations;
    }

       @Override
    public int getRowCount() {
        return (int) this.boardDimensions.getX();
    }

    @Override
    public int getColumnCount() {
        return (int) this.boardDimensions.getY();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return boardLocations[rowIndex][columnIndex];
    } 
   

    public Player getPlayerAt(int row, int column) {
        return this.boardLocations[row][column].getPlayer();
    }


  public void makeTheBoard() {
        
        for (int i = 0; i < this.boardLocations.length; i++) {
            Location[] rowlocations = this.boardLocations[i];
            for (int j = 0; j < rowlocations.length; j++) {
                rowlocations[j] = new Location();
                rowlocations[j].setPlayer(null);
                rowlocations[j].clearDeleteFlag();
            }
        }
    }  
  
  public void clearTheBoard() {
        for (int i = 0; i < this.boardLocations.length; i++) {
            Location[] rowlocations = this.boardLocations[i];
            for (int j = 0; j < rowlocations.length; j++) {
                rowlocations[j].setPlayer(null);
                rowlocations[j].clearDeleteFlag();
            }
        }
    }
    
    public boolean locationOccupied(Point location) {
        int row = location.x;
        int column = location.y;
        
        if (this.boardLocations[row][column].getPlayer() != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    public void occupyLocation(Player player, int row, int column)  {
        // subtract 1 from row and column number because the array starts a position 0

         Player playerAtLocation = this.boardLocations[row][column].getPlayer();

        if (playerAtLocation != null) { // location already occupied
            new CrazyConnectFourError().displayError("This location is already occupied. "
                    + "Try a different location.");
        }
        this.boardLocations[row][column].setPlayer(player);
    }

    
    public void removeMatches(){
        for (int i = 0; i < this.boardLocations.length; i++) {
            Location[] rowlocations = this.boardLocations[i];
            for (int j = 0; j < rowlocations.length; j++) {
                if (rowlocations[j].checkDeleteFlag()){
                  Player player = rowlocations[j].getPlayer();
                  player.setCurrentScore(player.getCurrentScore() + 1);  
                  rowlocations[j].setPlayer(null);
                  rowlocations[j].clearDeleteFlag();
                }
            }
        }
    }

    
    public void cascadeBoard(){
        for (int i = this.boardLocations.length - 1; i >0; i--) {
            Location[] rowlocations = this.boardLocations[i];
            for (int j = rowlocations.length - 1; j >= 0; j--) {
                if (rowlocations[j].getPlayer() == null){
                  boardLocations[i][j].setPlayer(boardLocations[i-1][j].getPlayer());
                  boardLocations[i-1][j].setPlayer(null);
                }
                
            }
        }
    }
}
