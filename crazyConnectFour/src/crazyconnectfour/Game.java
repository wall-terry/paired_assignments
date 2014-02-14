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
public class Game {
    public final static String PLAYER_A_DEFAULT_MARKER = "RED";
    public final static String PLAYER_B_DEFAULT_MARKER = "BLACK";
    
    
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

    public String gameType;
    public Player playerA;
    public Player playerB;
    public Player currentPlayer;
    public Player otherPlayer;
    public Player winner;
    public Player loser;
    public String status;
    public Board board;

    public Game() {
   
       this.playerA = new Player();
       this.playerB = new Player();
       
       this.playerA.token = Game.PLAYER_A_DEFAULT_MARKER;
       this.playerB.token = Game.PLAYER_B_DEFAULT_MARKER;
    }

    public Game(String gameType) {
        this();

        this.gameType = gameType;
        this.board = new Board(8, 8);
        
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
        if (this.currentPlayer == this.playerA) {
            this.winner = this.playerA;
            this.loser = this.playerB;
        } else {
            this.winner = this.playerB;
            this.loser = this.playerA;
        }

        long noWins = this.winner.wins;
        noWins++;
        this.winner.wins = noWins;
        long noLosses = this.loser.losses;
        noLosses++;
        this.loser.losses = noLosses;

        this.status = Game.WINNER;
        
    }

    public void recordTie() {
        long player1Ties = this.playerA.ties;
        player1Ties++;
        this.playerA.ties = player1Ties;
        long player2Ties = this.playerB.ties;
        player2Ties++;
        this.playerB.ties =player2Ties;

        this.status = Game.TIE;
       
    }



    public String getWinningMessage () {
        return "\n\t*******************************************************************************"
             + "\n\t Congratulations " + winner.name + "! You won the game."
             + "\n\t Sorry " + loser.name + ", You are the loser." 
             + "\n\t*******************************************************************************";
    }

    public String getTiedMessage () {
       return "\n\t*******************************************************************************"
             + "\n\t The game is a tie. Better luck next time!" 
             + "\n\t*******************************************************************************";
    }
       
}
