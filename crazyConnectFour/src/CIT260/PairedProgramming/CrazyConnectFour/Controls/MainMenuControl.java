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

package CIT260.PairedProgramming.CrazyConnectFour.Controls;

import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.ErrorType;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Player;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Game;
import CIT260.PairedProgramming.CrazyConnectFour.Views.GameMenuView;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.CrazyConnectFourError;
import CIT260.PairedProgramming.CrazyConnectFour.Views.HelpMenuView;
import java.util.Scanner;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.StatusType;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.PlayerType;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.GameType;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.MenuException;

/**
 *
 * @author Terry Wall
 */
public class MainMenuControl {

     
      public void startGame(long noPlayers) throws MenuException {
                
        if (noPlayers != 1  &&  noPlayers != 2) {
            throw new MenuException(ErrorType.ERROR105.getMessage());
        }
        
        Game game;
        try{
        if (noPlayers == 1) {
            game = this.createGame(GameType.ONE_PLAYER);
        }
        else {
            game = this.createGame(GameType.TWO_PLAYER);
        }
        }catch(MenuException ex){
            throw ex;
        }
        GameMenuView gameMenu = new GameMenuView(game);
        try { 
        gameMenu.getInput(game);
        
            } catch (MenuException ex) {
               System.out.println(ex.getMessage());
            }
            
    }

    
    
    private Game createGame(GameType gameType) throws MenuException{
        Game game = null;
        Player playerA = null;
        Player playerB = null;
        
        if (gameType == null) {
            throw new MenuException(ErrorType.ERROR108.getMessage());
        }
        
        if (gameType.equals(GameType.ONE_PLAYER)) {
            game = new Game(GameType.ONE_PLAYER);
            playerA = new Player(PlayerType.REGULAR_PLAYER, Game.PLAYER_A_DEFAULT_TOKEN);
            playerA.setName (Game.PLAYER_A_DEFAULT_NAME);
            playerB = new Player(PlayerType.COMPUTER_PLAYER, Game.PLAYER_B_DEFAULT_TOKEN);
            playerB.setName ("Computer");
        }
        else if (gameType.equals(GameType.TWO_PLAYER)) {
            game = new Game(GameType.TWO_PLAYER);
            playerA = new Player(PlayerType.REGULAR_PLAYER, Game.PLAYER_A_DEFAULT_TOKEN);
            playerA.setName (Game.PLAYER_A_DEFAULT_NAME);
            playerB = new Player(PlayerType.REGULAR_PLAYER, Game.PLAYER_B_DEFAULT_TOKEN);
            playerB.setName (Game.PLAYER_B_DEFAULT_NAME);

        }

        // set default tokens for each player
        playerA.setToken (Game.PLAYER_A_DEFAULT_TOKEN);
        playerB.setToken (Game.PLAYER_B_DEFAULT_TOKEN);
        
        // save the two players created as the default players of the game
        game.setPlayerA(playerA);
        game.setPlayerB(playerB); 
        
        // set the game status to game not yet in playing mode
        game.setStatus(StatusType.NEW_GAME);
        
        return game;
    } 
    
    
    private StatusType quitGame() {
        System.out.println("\n\tAre you sure you want to quit? (Y or N)");
        Scanner inFile = new Scanner(System.in);
        String answer = inFile.next().trim().toUpperCase();
        if (answer.equals("Y")) {
            return StatusType.EXIT;
        }

        return StatusType.PLAYING;
    }
    
    
    public void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        try {
       
        helpMenu.getInput(null);
    } catch (MenuException ex) {
       ErrorType.displayErrorMsg(ex.getMessage());
        }
        
    }

    public crazyconnectfour.Game create(GameType gameType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
        

