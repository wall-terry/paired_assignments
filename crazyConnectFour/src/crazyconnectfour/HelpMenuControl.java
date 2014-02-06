package crazyconnectfour;

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

/**
 *
 * @author dccoatney
 */
public class HelpMenuControl {
    
}
    
    public HelpMenuControl() {
        
    } 

    public void displayBoardHelp() {
        System.out.println();
        this.displayHelpBorder();             
        System.out.println( 
                "\tThe game board for CrazyConnectFour. The default board consists of 8 columns that can be stacked 8 positions high "
                + "\n\t. Players place their tokens in one of the 8 columns and it drops to the lowest empty position"
                + "\n\ton the board in an effort to win the game. The goal is to 4 tokens in a row horizontally, vertically or diagonally");

 
        displayHelpBorder();
    }
   
        
    public void displayGameHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                 "\tThe objective of the game is to be the first player to mark three "
                + "\n\tsquares vertically, horizontally or diagonally. Each player takes "
                + "\n\tturns placing their marker in one of the locations on the "
                + "\n\tboard. The first player to get \"three-in-a-row\" is the winner."
                ); 
        displayHelpBorder();
    }
            
    public void displayRealPlayerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tA real player manually takes their turn by placing their mark "
                + "\n\tin an unused location on the board."
                ); 
        displayHelpBorder();
    }
    
                   
    public void displayComputerPlayerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tA computer based player automatically takes its turn "
                + "\n\timmediatly after a real player in a single player game."
                ); 
        displayHelpBorder();
    }
             
    public void displayLocationHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
               "\tA location on the board where a player can place their marker"
                ); 
        displayHelpBorder();
    }
                 
    public void displayMarkerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
               "\tA symbol that \"marks\" the locations in the board that are occupied "
                + "by a player. "
                + "\n\tThe default markers are \"X\" and \"O\"."
                ); 
        displayHelpBorder();
    }
    
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
  
}
