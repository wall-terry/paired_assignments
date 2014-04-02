/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CIT260.PairedProgramming.CrazyConnectFour.Controls;

import CIT260.PairedProgramming.CrazyConnectFour.Views.MainMenuView;
import java.util.Scanner;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.MenuException;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.CrazyConnectFourException;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.ErrorType;
import CIT260.PairedProgramming.CrazyConnectFour.Frames.MainFrame;

/**
 *
 * @author Terry Wall and Crystal Coatney
 */
public class CrazyConnectFour {
    public static MainFrame mainFrame = null;
    
    private static final Scanner inFile = new Scanner(System.in);
  
    
    // Instance variables
    
     private final static String WELCOME = 
              "\n\t***********************************************************************"
            + "\n\t* Welcome to the game of Crazy Connect Four !                         *" 
            + "\n\t*                                                                     *"
            + "\n\t* The object of the game is to get four in a row vertically,          *"
            + "\n\t* horizontally, or diagonally.  Then the fun starts. The four aligned *"
            + "\n\t* align tokens will be removed and the tokens above will drop done.   *" 
            + "\n\t* This will result in new combinations of four or more in a row which *"
            + "\n\t* will also be removed resulting in a cascading effect.  This will    *"
            + "\n\t* continue until no more combination of four or more are made.  Point *"
            + "\n\t* will be scored for every token removed from the board for each      *"
            + "\n\t* player.  Play continues until all tokens are used.                  *"
            + "\n\t* Good Luck!!!                                                        *"
            + "\n\t***********************************************************************"
            + "\n";
     
     public CrazyConnectFour() {
              
     }
     
 
     public static Scanner getInputFile() {
        return CrazyConnectFour.inFile;
     }
    
    public static void main(String[] args) {
        CrazyConnectFour currentGame = null;
        try {
         currentGame = new CrazyConnectFour();
    
           java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                   CrazyConnectFour.mainFrame = new MainFrame();
                    
                   CrazyConnectFour.mainFrame.setVisible(true);
                }
            });
        } catch (Throwable ex){
            ErrorType.displayErrorMsg("Unexpected Error: " + ex.getMessage());
            ErrorType.displayErrorMsg(ex.getStackTrace().toString());
            
        } finally {
            if (CrazyConnectFour.mainFrame !=null) {
                CrazyConnectFour.mainFrame.dispose();
            }
        }
    
        currentGame.display();
        MainMenuView mainMenu = new MainMenuView();
        try {
            mainMenu.getInput(null);
        } catch (MenuException ex) {
            ErrorType.displayErrorMsg(ex.getMessage());
        }
        finally {
        CrazyConnectFour.inFile.close();
        
        }
    }
    private void display() {
        System.out.println(CrazyConnectFour.WELCOME);
    }     
        
}
