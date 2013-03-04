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
    
    private static Player[] player = new Player[2];
    public static Board board = new Board();
    public static Renderer renderer = new CLI();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        player[0] = new Human(Space.State.X);
        player[1] = new AI(Space.State.O);
        
        boolean gameOn = true;
        while(gameOn) {
            for(int i = 0; i < player.length; i++) {
                if(!gameWon() && !board.isFull()) {
                    if(player[i].getClass() == Human.class) {
                        renderer.renderBoard();
                        System.out.println();
                    }
                    boolean fail;
                    do {
                        try {
                            board.setSpace(player[i].prompt(), player[i].getState());
                            fail = false;
                        } catch(RuntimeException e) {
                            fail = true;
                        }
                    } while(fail);
                } else {
                    renderer.renderBoard();
                    if(winDetect(player[0].getState())) {
                        renderer.renderWin("Human");
                    } else if(winDetect(player[1].getState())){
                        renderer.renderWin("AI");
                    } else {
                        renderer.renderWin("cat");
                    }
                    board.reset();
                    break;
                }
            }
        }
        System.out.println("Thanks for Playing TicTacToe!\n\tBy Gustave Michel III");
    }
    
    public static boolean gameWon() {
        if(winDetect(Space.State.X) || winDetect(Space.State.O)) {
            return true;
        }
        return false;
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
