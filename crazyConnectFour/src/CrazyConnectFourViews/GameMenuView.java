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

package CrazyConnectFourViews;

import CrazyConnectFourExceptions.CrazyConnectFourError;
import CrazyConnectFourModels.Game;
import citbyui.cit260.CrazyConnectFour.Controls.GameMenuControl;
import CrazyConnectFourEnumerations.StatusType;

/**
 *
 * @author Terry Wall
 */
public class GameMenuView extends Menu{
    
    
    private  GameMenuControl gameMenuControl; 
    private  Game game;

    private final static String[][] menuItems = {
        {"T", "Take your turn"},
        {"D", "Display the board"},
        {"N", "New Game"},
        {"R", "Report Top Scores"},
        {"P", "Change game preferences"},
        {"H", "Help"},
        {"Q", "QUIT"}
    };

    public GameMenuView(Game game) {
        super(GameMenuView.menuItems);
        this.gameMenuControl = new GameMenuControl(game);
    }

    
    
    @Override
    public StatusType getInput(Object object) {
   
        this.game = (Game) object;

        StatusType gameStatus = StatusType.PLAYING;
        do {
     
            this.display();
            
            // get commaned entered
            String command = this.getCommand();
            switch (command) {
                case "T":
                    this.gameMenuControl.takeTurn();
                    break;
                case "D":
                    gameMenuControl.displayBoard();
                    break;
                case "N":
                    gameMenuControl.startNewGame();
                    break;
                case "R":
                    gameMenuControl.displayTopScores();
                    break;
                case "P":
                    gameMenuControl.displayPreferencesMenu();
                    break;
                case "H":
                    gameMenuControl.displayHelpMenu();
                    break;
                case "Q":
                    gameStatus = StatusType.QUIT;
                    break;
                default: 
                    new CrazyConnectFourError().displayError("Invalid command. Please enter a valid command.");
            }
        } while (!gameStatus.equals(StatusType.QUIT));
        
      return gameStatus;
    }
    
    @Override
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < GameMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }

}
