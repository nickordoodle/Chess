/**
 * 
 */
package chess;

/**
 * @author Nick
 * Used to set guideline of what a player
 * can or cannot do
 */
public interface PlayerAbilities {
	
	
	
	boolean isValidMove(String move, String[][] board);
	String[][] movePiece(String move, Piece piece, String[][] board);
	String toString();
	

}
