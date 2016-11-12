package chess;

/**
 * @author Nick and Kartik
 * Used to set guideline of what a player
 * can or cannot do
 */
public interface PlayerAbilities {
	
	String[][] movePiece(int srcRow, int srcCol, int dstRow, int dstCol, String[][] board);
	String toString();

}
