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

package CIT260.PairedProgramming.CrazyConnectFour.Enumerations;

/**
 *
 * @author dccoatney
 */
public enum ErrorType {
    ERROR101 ("You can not change the dimensions "
              + "of the board once the game has been started. "
              + "\n\tStart a new game and then change the dimensions "
              + "of the board. "),
    
    ERROR102 ("You must enter two numbers, the number rows and columns, "
              + "or a \"Q\" to quit. Try again."),
    
    ERROR104 ("That Token has already been selected by the other player. "
              + "Try again."),
    
    ERROR105 ("Invalid command. Please enter a valid command."),
    
    ERROR106 ("You must start a new game first."),
    
    ERROR107 ("You must enter a name or enter a \"Q\" to quit. Try again."),
    
    ERROR108 ("The game parameter is null."),
    
    ERROR109 ("You must enter two numbers, a row and the column, "
              + "or a \"Q\" to quit. Try again."),
    
    ERROR201 ("No empty locations found on the board"),
    
    ERROR203 ("This location is already occupied. Try a different "
              + "location."),
    
    ERROR204 ("Enter a non-blank token for the player's marker."),
    
    ERROR205 ("Both players can not use the same token for a marker."),
    
    ERROR206 ("There is no active game. You must start a new game before "
              + "you can take a turn"), 
    
    ERROR207 ("The number of rows must be between 6 - 15 and the "
              + "number of columns must be between 6 - 15 "),
    
    ERROR209 ("GameCommands - takeTurn: invalidPlayerTYpe");

    
    String message;
    
    ErrorType(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }

    
    public static void displayErorrMsg(String errorMessage) {
        String fullMessage = "\t+ ERROR: " + errorMessage + " +";
        int dividerLineLength = fullMessage.length();
        StringBuilder dividerLine = new StringBuilder(dividerLineLength);
        for (int i = 0; i < dividerLineLength; i++) {
            dividerLine.insert(i, '+');
        }
        System.out.println("\t" + dividerLine.toString());
        System.out.println(fullMessage);
        System.out.println("\t" + dividerLine.toString());
    }
    
    
  
}
