/**
 * 
 */
package pieces;

/**
 * @author Nick
 *
 */
public class Bishop extends Piece {
	
	
	
	public Bishop(char color, char type) {
		super(color, type);
	}

	public String toString(){
		return super.toString();
	}
	
	public boolean isValidMove(int srcRow, int srcCol, int dstRow, int dstCol, String[][] board) {
		
		return true;
	}

	

}
