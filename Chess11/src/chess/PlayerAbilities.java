/**
 * 
 */
package chess;

import pieces.Piece;

/**
 * @author Nick
 * Used to set guideline of what a player
 * can or cannot do
 */
public interface PlayerAbilities {
	
	
	String[][] movePiece(String move, Piece piece, String[][] board);
	String toString();
	

}
