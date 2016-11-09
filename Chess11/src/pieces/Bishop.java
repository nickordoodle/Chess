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
	
	public boolean isValidMove(String src, String dest, String[][] board) {
		
		return true;
	}

	

}
