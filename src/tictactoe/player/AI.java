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
    
    @SuppressWarnings("empty-statement")
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
                if(board.getSpace(TicTacToe.win[i][j]) == getState()) {
                    have++;
                }
            }
            if(have == 2) {
                for(int j = 0; j < TicTacToe.win[i].length; j++) {
                    if(board.getSpace(TicTacToe.win[i][j]) == Space.State.Empty) { //attempt to win
                        return TicTacToe.win[i][j];
                    }
                }
            }
        }
        
        for(int i = 0; i < TicTacToe.win.length; i++) { //Second priority, Block Opponent
            int taken = 0;
            
            for(int j = 0; j < TicTacToe.win[i].length; j++) {
                if(board.getSpace(TicTacToe.win[i][j]) == enemyState) { //find how many spaces enemy has on current TicTacToe.win cycle
                    taken++;
                }
            }
            if(taken == 2) {
                for(int j = 0; j < TicTacToe.win[i].length; j++) {
                    if(board.getSpace(TicTacToe.win[i][j]) == Space.State.Empty) { //attempt to block enemy TicTacToe.win
                        return TicTacToe.win[i][j];
                    }
                }
            }
        }
        
        for(int i = 0; i < TicTacToe.win.length; i++) { //Second priority, continue towards TicTacToe.win
            int have = 0;
            for(int j = 0; j < TicTacToe.win[i].length; j++) {
                if(board.getSpace(TicTacToe.win[i][j]) == getState()) {
                    have++;
                }
            }
            if(have == 1) {
                for(int j = 0; j < TicTacToe.win[i].length; j++) {
                    if(board.getSpace(TicTacToe.win[i][j]) == Space.State.Empty) { //attempt to TicTacToe.win
                        return TicTacToe.win[i][j];
                    }
                }
            }
        }
        
        for(int i = 0; i < board.getSpaces().length; i++) { //Fourth priority, first move?
            if(board.getSpace(i+1) == Space.State.Empty) {
                return i+1;
            }
        }
        return 0;
    }
}
