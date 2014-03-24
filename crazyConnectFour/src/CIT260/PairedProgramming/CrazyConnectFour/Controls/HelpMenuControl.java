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

package CIT260.PairedProgramming.CrazyConnectFour.Controls;

/**
 *
 * @author dccoatney
 */
public class HelpMenuControl {
    
    
    
    public HelpMenuControl() {
        
    } 

    public void displayBoardHelp() {
        System.out.println();
        this.displayHelpBorder();             
        System.out.println( 
                "\t The game board for CrazyConnectFour. The default board consists of 8 columns that can be stacked 8 positions"
                + "\n\t high. Players place their tokens in one of the 8 columns and it drops to the lowest empty position"
                + "\n\t on the board in an effort to get 4 tokens in a row horizontally, vertically or diagonally");

 
        displayHelpBorder();
    }
   
        
    public void displayGameHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                 "\t The objective of the game is to get four tokens in a row "
                + "\n\t vertically, horizontally or diagonally. Each player takes "
                + "\n\t turns placing their token in one of the columns on the "
                + "\n\t top of the board. When a player gets four tokens in a row"
                + "\n\t the tokens disappear and the tokens above will slide down to"
                + "\n\t to fill the empty spaces.  This may result in additional "
                + "\n\t combinations of 4 or more in a row which will also disappear"
                + "\n\t creating a cascade effect until no more combinations of four"
                + "\n\t are created. Points are scored for each token that disappears"
                + "\n\t and play continues until all the tokens are gone or no more"
                + "\n\t plays can be made."
                ); 
        displayHelpBorder();
    }
            
    public void displayRealPlayerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\t A real player manually takes their turn by placing their token "
                + "\n\t in an unused location on the board. This becomes a two player"
                + "\n\t version of the game with each player taking their turn."
                ); 
        displayHelpBorder();
    }
    
                   
    public void displayComputerPlayerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\t A computer based player automatically takes its turn "
                + "\n\t immediatly after a real player in a single player game."
                ); 
        displayHelpBorder();
    }
             
    public void displayColumnHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
               "\t A Column on the board where a player can place their token and"
                + "\n\t it will drop to the lowest unoccupied space."
                ); 
        displayHelpBorder();
    }
                 
    public void displayTokenHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
               "\t A symbol that \"marks\" the locations in the board that are occupied "
                + "\n\t by a player. The default token are  \"Red\" and \"Black\"."
                ); 
        displayHelpBorder();
    }
    
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
  
}
