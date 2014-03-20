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

package CrazyConnectFourModels;

import CrazyConnectFourModels.Player;

/**
 *
 * @author Terry Wall
 */
public class ScoreBoard  {
    public long scoreArray[];
    public String nameArray[];
    public Player player;
    
    
    public ScoreBoard(){
    scoreArray = new long[10];
    nameArray = new String[10];
    int i;
    for (i=0; i<10; i++) {
        scoreArray[i] = 0;
        nameArray[i] = "";
    }
   }
    
    public boolean addScore(long newScore, Player player){
    
        this.player = player;
        boolean success = false;
        long temp = 0;
        String stringTemp = "";
        String newName ;
        int i;
        String outMessage;
        
        if (newScore > 0){
            for (i= 0; i < 10 && success == false; i++){
                if (newScore > scoreArray[i]){
                    temp = scoreArray[i];
                    stringTemp = nameArray[i];
                    scoreArray[i] = newScore;
                    nameArray[i] = player.getName();
                    success = true;
                }
            } 
        if (success == true){
            do {
                newScore = temp;
                newName = stringTemp;
                temp = scoreArray[i];
                stringTemp = nameArray[i];
                scoreArray[i] = newScore;
                nameArray[i] = newName;
                i++;          
            } while(i<10);
        }
            
       }    
            return success;
    }
    public boolean listScores(){
        
        boolean success = false;
        int i;
        
        for (i=0; i<10; i++){
            
            System.out.println("\n\t " + nameArray[i] + "\t" + scoreArray[i]);
        }
        return success;
    }
        
}      
