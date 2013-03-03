/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import tictactoe.board.Board;
import tictactoe.board.Space;
import tictactoe.player.AI;
import tictactoe.player.Human;
import tictactoe.player.Player;
import tictactoe.render.CLI;
import tictactoe.render.Renderer;

/**
 *
 * @author Gustave Michel
 */
public class TicTacToe {
    public static int[][] win = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9},
        {1,4,7},
        {2,5,8},
        {3,6,9},
        {1,5,9},
        {3,5,7}
    };
    
    private static Player player1;
    private static Player player2;
    public static Board board = new Board();
    public static Renderer renderer = new CLI();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        player1 = new Human(Space.State.X);
        player2 = new AI(Space.State.O);
        
        while((!winDetect(player1.getState()) && !winDetect(player2.getState())) && !board.isFull()) {
            renderer.renderBoard();
            boolean fail;
            do {
                fail = false;
                try {
                    board.setSpace(player1.prompt(), player1.getState());
                } catch(RuntimeException e) {
                    if(board.isFull()) {
                        break;
                    }
                    fail = true;
                }
            } while(fail);
            
            do {
                fail = false;
                try {
                    board.setSpace(player2.prompt(), player2.getState());
                } catch(RuntimeException e) {
                    if(board.isFull()) {
                        break;
                    }
                    fail = true;
                }
            } while(fail);
        }
        renderer.renderBoard();
        if(winDetect(player1.getState())) {
            System.out.println("PLAYER1 WIN!");
        } else if(winDetect(player2.getState())) {
            System.out.println("PLAYER2 WIN!");
        } else {
            System.out.println("CAT GAME!");
        }
    }
    
    public static boolean winDetect(Space.State state) {
        int have;
        for(int i = 0; i < win.length; i++) {
            have = 0;
            for(int j = 0; j <win[i].length; j++) {
                if(board.getSpace(win[i][j]) == state) {
                    have++;
                }
            }
            if(have == 3) {
                return true;
            }
        }
        return false;
    }
}
