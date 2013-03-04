/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.render;

/**
 *
 * @author Gustave Michel
 */
public abstract class Renderer {
    public abstract void renderBoard();
    
    public abstract String promptHuman();
    
    public abstract void renderWin(String name);
    
    public abstract boolean promptContinue(String name);
}
