/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.board;

/**
 *
 * @author Gustave Michel
 */
public class BoardOverwriteException extends RuntimeException{
    public BoardOverwriteException() {
        super();
    }
    
    public BoardOverwriteException(String s) {
        super(s);
    }
}
