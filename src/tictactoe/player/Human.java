/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.player;

import tictactoe.TicTacToe;
import tictactoe.board.Space;

/**
 *
 * @author Gustave Michel
 */
public class Human extends Player {
    
    public Human(Space.State state) {
        super(state);
    }
    
    @Override
    public int prompt() {
        return TicTacToe.renderer.promptHuman();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
