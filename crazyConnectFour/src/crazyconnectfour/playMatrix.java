/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crazyconnectfour;

/**
 *
 * @author Terry Wall
 */
public class PlayMatrix {
    int options[];
    int matrix[][];
   
    
    public void addToken(int columnnumber, int playernumber) {
        System.out.println("This method allows a token to be added to a collumn");
        
    }
    public void checkForFour(){
        System.out.println("This method checkes the matrix for four or more in a row");
           }
    public void removeAndCascade(){
    
        System.out.println("This method cascades the tiles if matches are found");
    }
}
