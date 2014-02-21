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

package crazyconnectfour;

import java.util.Scanner;

/**
 *
 * @author Terry Wall
 */
public class MainMenuControl {

     
      public void startGame(long noPlayers) {
                
        if (noPlayers != 1  &&  noPlayers != 2) {
            new CrazyConnectFourError().displayError("startGame - invalid number of players specified.");
            return;
        }
        
        Game game;
        if (noPlayers == 1) {
            game = this.createGame("ONE_PLAYER");
        }
        else {
            game = this.createGame("TWO_PLAYER");
        }

        GameMenuView gameMenu = new GameMenuView(game);
        gameMenu.getInput();
    }

    
    
    private Game createGame(String gameType) {
        Game game = null;
        Player playerA = null;
        Player playerB = null;
        
        if (gameType == null) {
            new CrazyConnectFourError().displayError("MainCommands - create: gameType is null");
            return null;
        }
        
        if (gameType.equals(Game.ONE_PLAYER)) {
            game = new Game(Game.ONE_PLAYER);
            playerA = new Player(Player.REGULAR_PLAYER, Game.PLAYER_A_DEFAULT_TOKEN);
            playerA.name = Game.PLAYER_A_DEFAULT_NAME;
            playerB = new Player(Player.COMPUTER_PLAYER, Game.PLAYER_B_DEFAULT_TOKEN);
            playerB.name = "Computer";
        }
        else if (gameType.equals(Game.TWO_PLAYER)) {
            game = new Game(Game.TWO_PLAYER);
            playerA = new Player(Player.REGULAR_PLAYER, Game.PLAYER_A_DEFAULT_TOKEN);
            playerA.name = Game.PLAYER_A_DEFAULT_NAME;
            playerB = new Player(Player.REGULAR_PLAYER, Game.PLAYER_B_DEFAULT_TOKEN);
            playerB.name = Game.PLAYER_B_DEFAULT_NAME;

        }

        // set default tokens for each player
        playerA.token = Game.PLAYER_A_DEFAULT_TOKEN;
        playerB.token = Game.PLAYER_B_DEFAULT_TOKEN;
        
        // save the two players created as the default players of the game
        game.playerA = playerA;
        game.playerB = playerB; 
        
        // set the game status to game not yet in playing mode
        game.status = Game.NO_ACTIVE_GAME;
        
        return game;
    } 
    
    
    private String quitGame() {
        System.out.println("\n\tAre you sure you want to quit? (Y or N)");
        Scanner inFile = new Scanner(System.in);
        String answer = inFile.next().trim().toUpperCase();
        if (answer.equals("Y")) {
            return Game.EXIT;
        }

        return Game.PLAYING;
    }
    
    
    public void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.getInput();
    }
        
}
