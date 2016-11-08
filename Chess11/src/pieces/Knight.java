/**
 * 
 */
package pieces;

/**
 * @author Nick
 *
 */
public class Knight extends Piece {

	public Knight(char color, char type) {
		super(color, type);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return super.toString();
	}
	
	public boolean isValidMove(String move, String[][] board){
		
		return true;
	}

}
