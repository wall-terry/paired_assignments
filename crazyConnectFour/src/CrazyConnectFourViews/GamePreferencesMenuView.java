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
/*author Crystal Coatney*/

package CrazyConnectFourViews;

import crazyconnectfour.CrazyConnectFourError;
import CrazyConnectFourModels.Game;
import CrazyConnectFourControls.GamePreferencesMenuControl;
import CrazyConnectFourModels.Menu;
import java.util.Scanner;


public class GamePreferencesMenuView extends Menu {
    
    Game game;
    private GamePreferencesMenuControl gamePreferenceControl;

    private final static String[][] menuItems = {
        {"1", "Change Token of the first Player"},
        {"2", "Change Token of the second Player"},
        {"N", "Change Player Names"},
        {"D", "Change the dimensions of the board"},
        {"Q", "Return to game menu"}
   
    };

    
 public GamePreferencesMenuView() {
     
        super(GamePreferencesMenuView.menuItems);
        gamePreferenceControl = new GamePreferencesMenuControl();
 }
 
    @Override
    public String getInput(Object object) {       
        this.game = (Game) object;
        this.gamePreferenceControl.setGame(game);
        
        String gameStatus = Game.PLAYING;
        do {
            this.display();

            // get commaned entered
            String command = this.getCommand();
            
            switch (command) {
                case "1":
                    this.gamePreferenceControl.getToken(this.game.getPlayerA());
                    System.out.println("\n\t Player 1 is using "+ this.game.getPlayerA().getToken() + " as a token");
                    System.out.println("\n\t Player 2 is using "+ this.game.getPlayerB().getToken() + " as a token");
                    break;
                case "2":
                    this.gamePreferenceControl.getToken(this.game.getPlayerB());
                    System.out.println("\n\t Player 1 is using "+ this.game.getPlayerA().getToken() + " as a token");
                    System.out.println("\n\t Player 2 is using "+ this.game.getPlayerB().getToken() + " as a token");
                    break;
                case "D":
                    this.gamePreferenceControl.getDimensions();
                    break;
                case "N":
                    this.gamePreferenceControl.getPlayerNames();
                case "Q":
                    gameStatus = Game.QUIT;
                    break;
                default: 
                    new CrazyConnectFourError().displayError("Invalid command. Please enter a valid command.");
                    continue;
            }
        } while (!gameStatus.equals(Game.QUIT));

        return gameStatus;
    }
    
/*    
        
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");
        for (String[] menuItem : GamePreferencesMenuView.menuItems) {
            System.out.println("\t   " + menuItem[0] + "\t" + menuItem[1]);
        }
        System.out.println("\t===============================================================\n");
    }
 */
}


