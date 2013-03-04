/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.player;

import tictactoe.TicTacToe;
import tictactoe.board.Board;
import tictactoe.board.Space;

/**
 *
 * @author Gustave Michel
 */
public class AI extends Player {
    private Space.State enemyState;
    private Board board = TicTacToe.board;
    
    public abstract class Difficulty {
        
        public abstract int getMove(Board board);
        
    }
    
    public class Easy extends Difficulty {

        @Override
        public int getMove(Board board) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    public class Medium extends Difficulty {

        @Override
        public int getMove(Board board) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    public class Hard extends Difficulty {

        @Override
        public int getMove(Board board) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    public AI(Space.State state) {
        super(state);
        if(getState() == Space.State.O) {
            enemyState = Space.State.X;
        } else {
            enemyState = Space.State.O;
        }
    }
    
    @Override
    public int prompt() {
        return makeMove();
    }
    
    private int makeMove() {
        for(int i = 0; i < TicTacToe.win.length; i++) { //First priority, try to win
            int have = 0;
            
            for(int j = 0; j < TicTacToe.win[i].length; j++) {
                if(board.getSpace(TicTacToe.win[i][j]) == getState()) { //Scan win combination for Possitions
                    have++;
                }
            }
            if(have == 2) { //Check for almost win condition
                for(int j = 0; j < TicTacToe.win[i].length; j++) {
                    if(board.getSpace(TicTacToe.win[i][j]) == Space.State.Empty) { //attempt to win
                        return TicTacToe.win[i][j];
                    }
                }
            }
        }
        
        for(int i = 0; i < TicTacToe.win.length; i++) { //Second priority, Block Opponent from win
            int taken = 0;
            
            for(int j = 0; j < TicTacToe.win[i].length; j++) {
                if(board.getSpace(TicTacToe.win[i][j]) == enemyState) { //find how many spaces opponent has on current win combo
                    taken++;
                }
            }
            if(taken == 2) {
                for(int j = 0; j < TicTacToe.win[i].length; j++) {
                    if(board.getSpace(TicTacToe.win[i][j]) == Space.State.Empty) { //attempt to block opponent Win
                        return TicTacToe.win[i][j];
                    }
                }
            }
        }
        
        for(int i = 0; i < TicTacToe.win.length; i++) { //Third priority, continue towards Win
            int have = 0;
            int empty = 0;
            for(int j = 0; j < TicTacToe.win[i].length; j++) {
                if(board.getSpace(TicTacToe.win[i][j]) == getState()) {//Scan win combination for Possitions
                    have++;
                }
                if(board.getSpace(TicTacToe.win[i][j]) == Space.State.Empty) {
                    empty++;
                }
            }
            if(have == 1 && empty == 2) {
                for(int j = 0; j < TicTacToe.win[i].length; j++) {
                    if(board.getSpace(TicTacToe.win[i][j]) == Space.State.Empty) {
                        return TicTacToe.win[i][j];
                    }
                }
            }
        }
        
        for(int i = 0; i < board.getSpaces().length; i++) { //Fourth priority, Take first avalible space
            if(board.getSpace(i+1) == Space.State.Empty) {
                return i+1;
            }
        }
        return 0; //Error...
    }
}
