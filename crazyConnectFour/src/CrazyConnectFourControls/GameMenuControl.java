/*
 * The MIT License
 *
 * Copyright 2014 Terry Wall.
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

package CrazyConnectFourControls;

import CrazyConnectFourModels.Player;
import CrazyConnectFourModels.Location;
import CrazyConnectFourModels.Game;
import CrazyConnectFourModels.Board;
import CrazyConnectFourViews.GetPlayerNameView;
import CrazyConnectFourViews.GetLocationView;
import CrazyConnectFourViews.GamePreferencesMenuView;
import CrazyConnectFourViews.BoardView;
import CrazyConnectFourExceptions.CrazyConnectFourError;
import CrazyConnectFourViews.HelpMenuView;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import CrazyConnectFourEnumerations.StatusType;
import CrazyConnectFourEnumerations.PlayerType;
import CrazyConnectFourEnumerations.GameType;

/**
 *
 * @author Terry Wall, Crystal Coatney
 */

 
public class GameMenuControl {
    
    private Game game;
    private Board board;
    private GetLocationView getLocationView;
    private GetPlayerNameView getPlayerName;
    private BoardView boardView = new BoardView();

    
    public GameMenuControl(Game game) {
        this.game = game;
        this.board = game.getBoard();
    }
    
    
  public void takeTurn() {
       
        int returnValue = 1;
        
        if (!this.game.getStatus().equals(StatusType.NEW_GAME)  && 
            !this.game.getStatus().equals(StatusType.PLAYING)) {
            new CrazyConnectFourError().displayError("You must start a new game first.");
         
        }
         if (this.game.getGameType().equals(GameType.TWO_PLAYER)) { //two player game 
            // regular player takes turn
            returnValue = this.regularPlayerTurn(this.game.getCurrentPlayer());            
            if (returnValue < 0) {
                return;
            }
            this.checkForMatches();
            this.displayBoard();
            this.alternatePlayers(); // alternate players             
            
            // other player takes turn 
            returnValue = this.regularPlayerTurn(this.game.getCurrentPlayer());            
            if (returnValue < 0) {
                return;
            }
            this.checkForMatches();
            this.displayBoard();
            this.alternatePlayers(); // alternate players
        }
        
        else { // one player game
            // regular player takes turn
            this.regularPlayerTurn(this.game.getCurrentPlayer());
            if (returnValue < 0  || this.gameOver(this.game.getCurrentPlayer())) {
                return;
            }
        
            // computer takes turn         
            this.coumputerTakesTurn(this.game.getOtherPlayer());
            System.out.println("\n\tThe computer also took it's turn");
            this.displayBoard();            
            if (returnValue < 0  || this.gameOver(this.game.getOtherPlayer())) {
                return;
            }
        }
    
  }
    public void displayBoard() {
         boardView.displayBoard(this.board);
   }
   
   
    public void startNewGame() {
       this.game.start();
       this.displayBoard();     
    }
    
    
            
    public void displayPreferencesMenu() {
        
       if (this.game.getStatus().equals(StatusType.PLAYING)) {
            new CrazyConnectFourError().displayError("You can not change the preferences "
              + "of the game once the game has been started. "
              + "\n\tStart select a new game and then change then preferences ");
            return;}
       
        GamePreferencesMenuView gamePreferencesMenu = new GamePreferencesMenuView();
        gamePreferencesMenu.getInput(this.game);
   
    }
    
    
    public void displayTopScores() {
        
        boolean status;
        String command;
        Scanner inFile = new Scanner(System.in);
        int stringToInteger;
        
        status = this.game.getScoreBoard().listScores();
        
        do {    
            System.out.println("\n\t enter new score for player one or player two by typing 1 for player one"
                                + "\n\t or 2 for player 2");
            
            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "1":
                    System.out.println("\n\t enter new score for player one");
                                
                    command = inFile.nextLine();
                    stringToInteger = Integer.parseInt(command);
                    status = this.game.getScoreBoard().addScore(stringToInteger, this.game.getPlayerA());
                    status = this.game.getScoreBoard().listScores();
                    break;
                case "2":
                    System.out.println("\n\t enter new score for player two");
                               
                    command = inFile.nextLine();
                    stringToInteger = Integer.parseInt(command);
                    status = this.game.getScoreBoard().addScore(stringToInteger, this.game.getPlayerB());
                    status = this.game.getScoreBoard().listScores();
                    break;
                case "Q":                   
                    break;
                default: 
                    new CrazyConnectFourError().displayError("Invalid command. Please enter a valid command.");
            }
        } while (!command.equals("Q"));
        
        /*
        String playerAStatistics = this.game.playerA.getPlayerStastics();
        String playerBStatistics = this.game.playerB.getPlayerStastics();
        System.out.println("\n\t++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\t " + playerAStatistics);
        System.out.println("\n\t " + playerBStatistics);
        System.out.println("\t+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        */
    }
    
    public void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.getInput(null);
    } 
      private boolean gameOver(Player player) {
        
            return true;
        }
        
    
    private void displayGameOverMessage(Player player, String message) {
        System.out.println("\n\t************************************************");
        System.out.println("\t " + player.getName() + ": " + message);
        System.out.println("\t************************************************");
    }
    
    /*
     * A regular player takes a turn
     * @parameter player The player taking the turn
     */
    private int regularPlayerTurn(Player player) {
        
        if (!this.game.getStatus().equals(StatusType.NEW_GAME)  &&
            !this.game.getStatus().equals(StatusType.PLAYING)) {
            new CrazyConnectFourError().displayError(
                    "There is no active game. You must start a new game before "
                    + "you can take a turn");
            return -1;
        } 
        
        this.game.setStatus(StatusType.PLAYING);
        
        GetLocationView getLocationView = new GetLocationView(this.game);
        Point location = getLocationView.getInput();
        if (location == null) { // no location was entered?
            return -1;
        }
            
        this.game.getBoard().occupyLocation(player, location.x, location.y);
        
        return 0;
    }
    
     /*
     * A regular player takes a turn
     * @parameter player The player who is the computer
     */
    private void coumputerTakesTurn(Player player) {
        // computer takes turn 
        Point location = this.getComputersSelection();
        this.game.getBoard().occupyLocation(player, location.x, location.y);
        return;
    }
    


    /*
     * Alternate players
     */
    public void alternatePlayers() {
        if (this.game.getCurrentPlayer() == this.game.getPlayerA()) {
            this.game.setCurrentPlayer (this.game.getPlayerB()) ;
            this.game.setOtherPlayer(this.game.getPlayerA());
        } else {
            this.game.setCurrentPlayer(this.game.getPlayerA());
            this.game.setOtherPlayer(this.game.getPlayerB()) ;
        }
    }
    


    
    
    /* 
     * Get computers selection
     */
    private Point getComputersSelection() {
        Point coordinate;

        coordinate = this.findWinningLocation(game.getCurrentPlayer());
        if (coordinate != null) { // winning location found for computer
            return coordinate;
        }

        // find winning location for other player
        coordinate = this.findWinningLocation(game.getOtherPlayer());
        if (coordinate == null) { // no winning location found for other player
            coordinate = this.chooseRandomLocation();

            if (coordinate == null) {
                new CrazyConnectFourError().displayError("No empty locations found on the board");
                return null;
            }
        }
   
        return coordinate;
    }

    private void checkForMatches(){
        boolean matchesFound = false;
        do{
            matchesFound = this.fourInARow(this.board.getRowCount() - 1,this.board.getColumnCount()- 1,this.board.getBoardLocations());
            if (matchesFound == true){
                this.board.removeMatches();
                this.board.cascadeBoard();
            } else {
            }
        }while(matchesFound == true);
        
    }
    
    /* 
     * Are there four of the same markers in a row
     */
    private boolean fourInARow(int row, int col, Location [][] boardLocations) {
        
        int columnLength = boardLocations[row].length;
        int rowLength = boardLocations.length;
        int startRow;
        int currentRow;
        int startColumn;
        int currentColumn;
        int matches = 0;
        boolean fourOfAKindFound = false;
        int i,j,k;

        // check for horizontal sets of four in a row
        for ( i = 0; i < rowLength; i++){
        Location[] rowlocations = boardLocations[i];
        for ( j = 0, startColumn = 0, currentColumn = 0, matches = 0; j < columnLength-1; j++){
            if (rowlocations[j].getPlayer() == rowlocations[j+1].getPlayer()){
                currentColumn++;
                if(rowlocations[j].getPlayer() != null) matches++;
                else startColumn = currentColumn;
            }
            else if(matches < 3){
                currentColumn++;
                startColumn = currentColumn;
                matches = 0;
            }
            else {
                
                for (k = startColumn; k <= currentColumn; k++){
                   rowlocations[k].setDeleteFlag();
                }
                currentColumn++;
                startColumn = currentColumn;
                matches = 0;
                fourOfAKindFound = true;
                }
            }
            if (matches > 3) fourOfAKindFound = true;
        }
        
        
        // Search for Four or more in a row in a column
        
        for (j = 0; j < columnLength; j++){
            for ( i = 0, matches = 0,startRow =0, currentRow =0; i < rowLength - 1; i++){
               if (boardLocations [i][j].getPlayer() == boardLocations[i+1][j].getPlayer()){
                   currentRow++;
                   if (boardLocations[i][j].getPlayer()!= null) matches++;
                   else startRow = currentRow;
               } 
               else if (matches < 3){
                   currentRow++;
                   startRow = currentRow;
                   matches = 0;
               }
               else{
                   for (k = startRow; k <= currentRow; k++){
                       boardLocations[k][j].setDeleteFlag();
                   }
                   currentRow++;
                   startRow = currentRow;
                   matches = 0;
                   fourOfAKindFound = true;
               }
            }
            if( matches > 3) fourOfAKindFound = true;
        }
        

        return fourOfAKindFound;
    }

    /* 
     * Find a winning location
     */
    
    private Point findWinningLocation(Player player) {
        Point coordinate = new Point();
        Location [][] locations = this.board.getBoardLocations();
        for (int row = 0; row < locations.length; row++) {
            Location[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                Player playerAtLocation = rowLocations[col].getPlayer();
                coordinate.setLocation(row, col);

                if (rowLocations[col].getPlayer() != null) { // location is occupied
                    continue;
                }

                // search for three adjacent horizontally
                if ((row < locations.length
                        && col < rowLocations.length - 2)
                        && (locations[row][col + 1].getPlayer() == player)
                        && (locations[row][col + 2].getPlayer() == player)) {
                    return coordinate;
                } else if ((row < locations.length)
                        && (col > 0 && col < rowLocations.length - 1)
                        && (locations[row][col - 1].getPlayer()) == player
                        && (locations[row][col + 1].getPlayer() == player)) {
                    return coordinate;
                } else if ((row < locations.length && col > 1)
                        && (locations[row][col - 1].getPlayer()) == player
                        && (locations[row][col - 2].getPlayer() == player)) {
                    return coordinate;
                } // search for three adjacent vertically
                else if ((row < locations.length - 2
                        && col < rowLocations.length)
                        && (locations[row + 1][col].getPlayer()) == player
                        && (locations[row + 2][col].getPlayer() == player)) {
                    return coordinate;
                } else if ((row > 0 && row < locations.length - 1
                        && col < rowLocations.length)
                        && (locations[row - 1][col].getPlayer()) == player
                        && (locations[row + 1][col].getPlayer() == player)) {
                    return coordinate;
                } else if ((row > 1 && col < rowLocations.length)
                        && (locations[row - 1][col].getPlayer()) == player
                        && (locations[row - 2][col].getPlayer() == player)) {
                    return coordinate;
                } // search for three adjacent diagonally leaning backward
                else if ((row < locations.length - 2
                        && col < rowLocations.length - 2)
                        && (locations[row + 1][col + 1].getPlayer()) == player
                        && locations[row + 2][col + 2].getPlayer() == player){
                    return coordinate;
                } else if ((row > 0 && row < locations.length - 1)
                        &&( col > 0 && col < rowLocations.length - 1)
                        && (locations[row - 1][col + 1].getPlayer()) == player
                        && (locations[row + 1][col - 1].getPlayer() == player)) {
                    return coordinate;
                } else if ((row > 1 && col > 1)
                        && (locations[row - 1][col - 1].getPlayer()) == player
                        && (locations[row - 2][col - 2].getPlayer() == player)) {
                    return coordinate;
                } // search for three adjacent diagonally learning forward
                else if ((row < locations.length - 2 && col > 1)
                        && (locations[row + 1][col - 1].getPlayer()) == player
                        && (locations[row + 2][col - 2].getPlayer() == player)) {
                    return coordinate;
                } else if ((row > 0 && row < locations.length - 1
                        && col > 0 && col < rowLocations.length - 1)
                        && (locations[row - 1][col + 1].getPlayer()) == player
                        && (locations[row + 1][col - 1].getPlayer() == player)) {
                    return coordinate;
                } else if ((row > 1 && col < rowLocations.length - 2)
                        && (locations[row - 1][col + 1].getPlayer()) == player
                        && (locations[row - 2][col + 2].getPlayer() == player)) {
                    return coordinate;
                }
            }
        }

        return null; // not found
    }

    /* 
     * Choose a random location
     */
    private Point chooseRandomLocation() {
        Point randomLocation;

        ArrayList<Point> listOfEmptyLocations = new ArrayList<>();
        Location[][] locations = this.board.getBoardLocations();

        // create list of empty locations
        for (int row = 0; row < locations.length; row++) {
            Location[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                Player playerAtLocation = rowLocations[col].getPlayer();
                if (playerAtLocation == null) { // location not occupied?
                    listOfEmptyLocations.add(new Point(row, col));
                }
            }
        }

        int noOfEmptyLocations = listOfEmptyLocations.size();

        if (noOfEmptyLocations == 0) { // no empty locations?
            return null;
        } else if (listOfEmptyLocations.size() == 1) { // only one empty location?
            randomLocation = listOfEmptyLocations.get(0);
            return randomLocation;
        } else { // randomly choose one of the empty locations
            int randomNumber = new Random().nextInt(noOfEmptyLocations);
            randomLocation = listOfEmptyLocations.get(randomNumber);
            return randomLocation;
        }
    }
    
      /* 
     * Clear the board action
     */
    public void clearTheBoard() {
        Location [][] locations = this.game.getBoard().getBoardLocations();
        
        for (int i = 0; i < this.board.getBoardLocations().length; i++) {
           Location [] rowlocations = locations[i];
            for (Location rowlocation : rowlocations) {
                rowlocation.setPlayer(null);
            }
        }
    }
 
}
