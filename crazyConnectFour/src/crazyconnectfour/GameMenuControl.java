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

/**
 *
 * @author Terry Wall
 */
public class GameMenuControl {
    
  public void takeTurn() {
       
        System.out.println("\n\ttakeTurn() called");
    }
   
       
   public void displayBoard() {
        System.out.println("\n\tdisplayBoard() called");
    }
   
   
    public void startNewGame() {
        System.out.println("\n\tstartNewGame() called");
    }
    
    
            
    public void displayPreferencesMenu() {
        System.out.println("\n\t displayPreferencesMenu() called");
        

        GamePreferencesMenuView gamePreferencesMenu = new GamePreferencesMenuView();
        gamePreferencesMenu.getInput();
   
    }
    
    
    public void displayStatistics() {
        System.out.println("\n\t displayStatistics()) called");
        
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
        helpMenu.getInput();
    }     
}
