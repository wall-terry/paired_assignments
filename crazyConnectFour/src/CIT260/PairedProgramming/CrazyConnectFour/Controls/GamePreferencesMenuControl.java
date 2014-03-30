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

/* author Crystal Coatney, Terry Wall

*/
package CIT260.PairedProgramming.CrazyConnectFour.Controls;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.ErrorType;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Player;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Location;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Game;
import CIT260.PairedProgramming.CrazyConnectFour.Views.GetTokenView;
import CIT260.PairedProgramming.CrazyConnectFour.Views.GetPlayerNameView;
import CIT260.PairedProgramming.CrazyConnectFour.Views.GetDimensionsView;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.TokenException;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.BoardException;
import java.awt.Dimension;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.StatusType;



public class GamePreferencesMenuControl {  
    
      
    private Game game;

    public GamePreferencesMenuControl() {
        
    }
    
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    public void getToken(Player player) { 
        
        GetTokenView getTokenView = new GetTokenView(this.game);
        String token = "";
        try{
            token = getTokenView.getInput(player);
        }catch (TokenException ex){
            ErrorType.displayErrorMsg(ex.getMessage());
        }
        if (token == null) { // user changed there mind and quit??
            return;
        }
      
        player.setToken (token); // update the players markers
    }
  
    public void getPlayerNames(){
        
        GetPlayerNameView getPlayerNameView = new GetPlayerNameView(this.game);
        System.out.println("\n\t" 
                    + "Enter a name for player one with a minimum of 3 characters and a maximum of 12 charcters.\n\t"
                    + "You can also enter Q to keep the default or current name\n\t"
                    + "The current name is " + this.game.getPlayerA().getName());
        String name = getPlayerNameView.getInput();
        if (name != null) this.game.getPlayerA().setName(name);
        
        System.out.println("\n\t" 
                    + "Enter a name for player two with a minimum of 3 characters and a maximum of 12 charcters.\n\t"
                    + "You can also enter Q to keep the default or current name\n\t"
                    + "The Current name is " + this.game.getPlayerB().getName());
        
        name = getPlayerNameView.getInput();
        if (name != null) this.game.getPlayerB().setName(name);
    }

        public void getDimensions() throws BoardException {
        
        // Check to see if a game is already in progress
        if (this.game.getStatus().equals(StatusType.PLAYING)) {
            throw new BoardException(ErrorType.ERROR101.getMessage());
            
        }
         GetDimensionsView getDimensionsView = new GetDimensionsView(this.game);
        Dimension dimension = getDimensionsView.getInput();
        
        if (dimension == null) {    
            return;
        }
        
        int boardRowCount = dimension.width;
        int boardColumnCount= dimension.height;
         
        // no change in the board size so return
        if (boardRowCount == this.game.getBoard().getRowCount() &&
            boardColumnCount == this.game.getBoard().getColumnCount()) {
            return;
        }
        
        // change the size board
        Location [][] boardLocations = new Location [boardRowCount][boardColumnCount];
        this.game.getBoard().setBoardLocations(boardLocations);
        this.game.getBoard().makeTheBoard();
        this.game.getBoard().getBoardDimensions().setLocation(boardRowCount, boardColumnCount);
        
        
    }
}
    
    
        

     
