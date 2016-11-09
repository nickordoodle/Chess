/**
 * 
 */
package pieces;

/**
 * @author Nick
 *
 */
public class Pawn extends Piece {

	private boolean isFirstMove;
	private boolean isPromoted;

	public Pawn(char color, char type) {
		super(color, type);
		isFirstMove = true;
	}

	public String toString(){
		return super.toString();
	}
	
	// TODO: Must implement
	/*
	 * Cases: Check if column is the same and space is clear, if move is 2
	 * spaces and both spaces are clear, check if first move,
	 * 
	 * else move must be one space diagonal and enemy must be in that space
	 * 
	 * 
	 * TODO: IMPLEMENT THIS Special case: en passant capture
	 */
	public boolean isValidMove(String src, String dest, String[][] board) {
		
		return true;
	}

	public boolean isFirstMove() {
		return isFirstMove;
	}

	public void setFirstMove(boolean isFirstMove) {
		this.isFirstMove = isFirstMove;
	}

	public boolean isPromoted() {
		return isPromoted;
	}

	public void setPromoted(boolean isPromoted) {
		this.isPromoted = isPromoted;
	}

}
