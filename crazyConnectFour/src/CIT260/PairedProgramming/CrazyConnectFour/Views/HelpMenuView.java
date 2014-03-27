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


package CIT260.PairedProgramming.CrazyConnectFour.Views;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Game;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.CrazyConnectFourError;
import CIT260.PairedProgramming.CrazyConnectFour.Controls.HelpMenuControl;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.StatusType;


public class HelpMenuView extends Menu {
        
    private final static String[][] menuItems = {
        {"B", "The board"},
        {"C", "A computer player"}, 
        {"G", "Crazy Connect Four"},
        {"L", "A coulumn"},
        {"M", "A token"},
        {"R", "A regular player"},        
        {"Q", "Quit Help"}        
    };
    
    private final HelpMenuControl HelpMenuControl = new HelpMenuControl();
    
    public HelpMenuView() {
        super(HelpMenuView.menuItems);
    } 
    

    @Override
    public StatusType getInput(Object object) {       
              
        StatusType gameStatus = StatusType.PLAYING;
        do {
            this.display();
            // get commaned entered
            String command = this.getCommand();
            switch (command) {
                case "B":
                    this.HelpMenuControl.displayBoardHelp();
                    break;
                case "C":
                    this.HelpMenuControl.displayComputerPlayerHelp();
                    break;
                case "G":
                    this.HelpMenuControl.displayGameHelp();
                    break;                  
                case "L":
                    this.HelpMenuControl.displayColumnHelp();
                    break;
                case "M":
                    this.HelpMenuControl.displayTokenHelp();
                    break;
                 case "R":
                    this.HelpMenuControl.displayRealPlayerHelp();
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
    //displays the help menu
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        
        for (int i = 0; i < HelpMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
   
}

