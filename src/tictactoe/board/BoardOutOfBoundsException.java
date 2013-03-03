/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.board;

/**
 *
 * @author Gustave Michel
 */
public class BoardOutOfBoundsException extends RuntimeException {
    public BoardOutOfBoundsException() {
        super();
    }
    
    public BoardOutOfBoundsException(String s) {
        super(s);
    }
}
