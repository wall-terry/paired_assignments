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

package CIT260.PairedProgramming.CrazyConnectFour.Views;

import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.CrazyConnectFourError;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Game;
import CIT260.PairedProgramming.CrazyConnectFour.Controls.MainMenuControl;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.ErrorType;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.StatusType;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.MenuException;
/**
 *
 * @author Terry Wall
 */
public class MainMenuView extends Menu {
   
 private static final String[][] menuItems = {
        {"1", "One player game"},
        {"2", "Two player game"},
        {"H", "Help"},
        {"X", "Exit CrazyConnectFour"}
    }; 
  
    MainMenuControl mainMenuControl = new MainMenuControl();
    
    public MainMenuView() {
        super (MainMenuView.menuItems);
    }
 
    
      

    @Override
    public StatusType getInput (Object object) throws MenuException{       
        
        StatusType gameStatus = StatusType.PLAYING;
        String command = "";
        do {
            this.display();

            // get commaned entered
            try {
                command = this.getCommand();
            } 
            catch (MenuException ex) {
                 ErrorType.displayErorrMsg(ex.getMessage());
            }
            
            switch (command) {
                case "1":
                    this.mainMenuControl.startGame(1);
                    break;
                case "2":
                    this.mainMenuControl.startGame(2);
                    break;
                case "H":
                    this.mainMenuControl.displayHelpMenu();            
                    break;
                case "X":
                    gameStatus = StatusType.EXIT;
                    break;
                default: 
                    new CrazyConnectFourError().displayError("Invalid command. Please enter a valid command.");
            }
        } while (!gameStatus.equals(StatusType.EXIT));
        
      return gameStatus;
      
    }
    

   @Override
    
   public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");
     for (String[] menuItem : MainMenuView.menuItems) {
         System.out.println("\t   " + menuItem[0] + "\t" + menuItem[1]);
     }
        System.out.println("\t===============================================================\n");
    }   
   
}
