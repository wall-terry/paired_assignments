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
public class ScoreBoard  {
    
    int scoreArray[] = new int[2];
    
    boolean addScore(int newScore, int playerNumber ){
    
        boolean success = false;
        int temp;
        int tempTimesTen;
        String OutMessage;
        
        if (newScore > 0){
            temp = newScore + scoreArray[playerNumber];
            tempTimesTen = temp * 10;  // Just for the sake of the assignment
            scoreArray[playerNumber] = tempTimesTen / 10;
            OutMessage = "Player \"one\" has a score of " + scoreArray[0] + "\n Player two has score of " + scoreArray[1] +"\n";
            System.out.println(OutMessage);
            success = true;
            }
        return success;
    }
        
}      