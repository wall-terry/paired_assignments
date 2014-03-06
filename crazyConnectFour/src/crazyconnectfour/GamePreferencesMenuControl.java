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
package crazyconnectfour;
import java.awt.Dimension;



public class GamePreferencesMenuControl {  
    
      
    private Game game;

    public GamePreferencesMenuControl(Game game) {
        this.game = game;
    }
    
    
    public void getToken(Player player) { 
        
        GetTokenView getTokenView = new GetTokenView(this.game);
        String token = getTokenView.getInput(player);
        
        if (token == null) { // user changed there mind and quit??
            return;
        }
      
        player.token = token; // update the players markers
    }
  
    
    
    

        public void getDimensions()  {
        
        // Check to see if a game is already in progress
        if (this.game.status.equals(Game.PLAYING)) {
            new CrazyConnectFourError().displayError("You can not change the dimensions "
              + "of the board once the game has been started. "
              + "\n\tStart a new game and then change the dimensions "
              + "of the board. ");
            return;
        }
         GetDimensionsView getDimensionsView = new GetDimensionsView(this.game);
        Dimension dimension = getDimensionsView.getInput();
        
        if (dimension == null) {    
            return;
        }
        
        int boardRowCount = dimension.width;
        int boardColumnCount= dimension.height;
         
        // no change in the board size so return
        if (boardRowCount == this.game.board.getRowCount() &&
            boardColumnCount == this.game.board.getColumnCount()) {
            return;
        }
        
        // change the size board
        Location [][] boardLocations = new Location [boardRowCount][boardColumnCount];
        this.game.board.getBoardDimensions().setLocation(boardRowCount, boardRowCount);
        this.game.board.setBoardLocations(boardLocations);
    }
}
    
    
        

     
