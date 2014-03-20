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
import CrazyConnectFourModels.Board;
import java.io.Serializable; 


/**
 *
 * @author Terry Wall, Crystal Coatney
 */
public class Game implements Serializable {
    public final static String PLAYER_A_DEFAULT_TOKEN = "  RED ";
    public final static String PLAYER_B_DEFAULT_TOKEN = " BLACK";
    public final static String PLAYER_A_DEFAULT_NAME = "Aristotle";
    public final static String PLAYER_B_DEFAULT_NAME = "Euripedes";
    
    public static final String ONE_PLAYER = "ONE_PLAYER";
    public static final String TWO_PLAYER = "TWO_PLAYER";
    
    public static final String NO_ACTIVE_GAME = "NO_GAME_STARTED";
    public static final String NEW_GAME = "NEW_GAME";
    public static final String PLAYING = "PLAYING"; 
    public static final String WINNER = "WINNER"; 
    public static final String TIE = "TIE"; 
    public static final String QUIT = "QUIT"; 
    public static final String ERROR = "ERROR";
    public static final String EXIT = "EXIT";
    public static final int NUMBER_OF_ROWS_DEFAULT = 8;
    public static final int NUMBER_OF_COLUMNS_DEFAULT = 8;
    

    private String gameType;
    private Player playerA;
    private Player playerB;
    private Player currentPlayer;
    private Player otherPlayer;
    private Player winner;
    private Player loser;
    private String status;
    private Board board;
    private ScoreBoard scoreBoard;

    public Game() {
   
       this.playerA = new Player();
       this.playerB = new Player();
       this.scoreBoard = new ScoreBoard();
       
       this.playerA.setToken (Game.PLAYER_A_DEFAULT_TOKEN);
       this.playerB.setToken (Game.PLAYER_B_DEFAULT_TOKEN);
       this.playerA.setName (Game.PLAYER_A_DEFAULT_NAME);
       this.playerB.setName (Game.PLAYER_B_DEFAULT_NAME);
    }

    public Game(String gameType) {
        this();

        this.gameType = gameType;
        this.board = new Board(Game.NUMBER_OF_ROWS_DEFAULT, Game.NUMBER_OF_COLUMNS_DEFAULT);
        this.board.makeTheBoard();
        
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public void setPlayerA(Player playerA) {
        this.playerA = playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setPlayerB(Player playerB) {
        this.playerB = playerB;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void setLoser(Player loser) {
        this.loser = loser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }


    public void start() {

        this.setPlayingOrder(playerA, playerB);

        // clear the board
        this.board.clearTheBoard();
        this.status = Game.NEW_GAME;
        this.setPlayingOrder(this.playerA, this.playerB);
    }

    public void setPlayingOrder(Player player1, Player player2) {

        double randomValue = Math.random();

        if (randomValue < 0.5) {
            this.currentPlayer = player1;
            this.otherPlayer = player2;
        } else {
            this.otherPlayer = player2;
            this.currentPlayer = player1;
        }

    }

    public void recordWinner() {
        if (this.playerA.getCurrentScore() < playerB.getCurrentScore()) {
            this.winner = this.playerA;
          
        } else {
            this.winner = this.playerB;
        }
        
        this.scoreBoard.addScore(this.winner.getCurrentScore(),this.winner);
        this.getWinningMessage();        
        
    }

    public void recordTie() {
        this.scoreBoard.addScore(this.playerA.getCurrentScore(),this.playerA);
        this.scoreBoard.addScore(this.playerB.getCurrentScore(),this.playerB);
        this.getTiedMessage();
       
    }



    public String getWinningMessage () {
        this.scoreBoard.listScores();
        return "\n\t*******************************************************************************"
             + "\n\t Congratulations " + winner.getName() + "! You won the game."
             + "\n\t Your score was " + winner.getCurrentScore()  
             + "\n\t*******************************************************************************";
    
        
    }

    public String getTiedMessage () {
       this.scoreBoard.listScores();
       return "\n\t*******************************************************************************"
             + "\n\t The game is a tie. You both scored " + playerA.getCurrentScore() 
             + "\n\t*******************************************************************************";
    }
       
}
