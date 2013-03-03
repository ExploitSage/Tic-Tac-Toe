/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.render;

import java.util.Scanner;
import tictactoe.TicTacToe;
import tictactoe.board.Space;

/**
 *
 * @author Gustave Michel
 */
public class CLI extends Renderer {
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void renderBoard() {
        for(int i = 0; i < 9; i++) {
            if(TicTacToe.board.getSpace(i+1) == (Space.State.Empty)) {
                System.out.print(i+1);
            } else if(TicTacToe.board.getSpace(i+1).equals(Space.State.X)) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
            switch(i) {
                case 0:
                case 1:
                case 3:
                case 4:
                case 6:
                case 7:
                    System.out.print("|");
                    break;
                case 2:
                case 5:
                case 8:
                    System.out.println("\n-----");
            }
        }
    }

    @Override
    public int promptHuman() {
        System.out.print("Pick Next Move (1-9): ");
        return scanner.nextInt();
    }
    
}
