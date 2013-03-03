/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.board;

/**
 *
 * @author Gustave Michel
 */
public class Space {
    private State m_state;
    
    public static class State {
        private static final int X_val = 1;
        private static final int O_val = 2;
        private static final int E_val = 3;
        
        private int m_state;
        
        private State(int state) {
            m_state = state;
        }
        
        public static final State X = new State(X_val);
        public static final State O = new State(O_val);
        public static final State Empty = new State(E_val);
    }
    
    public Space() {
        m_state = State.Empty;
    }
    
    public Space(State state) {
        m_state = state;
    }
    
    public void setState(State state) {
        m_state = state;
    }
    
    public State getState() {
        return m_state;
    }
}
