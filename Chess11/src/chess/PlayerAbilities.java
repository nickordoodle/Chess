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
	
	
	String[][] movePiece(String src, String dest, String[][] board);
	String toString();
	

}
