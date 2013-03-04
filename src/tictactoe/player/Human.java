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
        boolean fail;
        String prompt;
        int output = 0;
        
        do {
            prompt = TicTacToe.renderer.promptHuman();
            try {
                output = Integer.parseInt(prompt);
                fail = false;
            } catch (NumberFormatException e) {
                fail = true;
            }
        } while(fail);
        return output;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
