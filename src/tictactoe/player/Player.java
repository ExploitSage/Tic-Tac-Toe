/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.player;

import tictactoe.board.Space;

/**
 *
 * @author Gustave Michel
 */
public abstract class Player {
    private Space.State m_state;
    
    public Player(Space.State state) {
        m_state = state;
    }
    
    public abstract int prompt();
    
    public Space.State getState() {
        return m_state;
    }
    
    public void changeState(Space.State state) {
        m_state = state;
    }
}
