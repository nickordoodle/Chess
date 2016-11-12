package pieces;

public class King extends Piece {

	public King(char color, char type) {
		super(color, type);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return super.toString();
	}
	
	public boolean isValidMove(int srcRow, int srcCol, int dstRow, int dstCol, String[][] board) {
		
		return true;
	}
	
	/*
	 * Returns true if the opponents next move by any of its pieces
	 * can take the king
	 * 
	 * Otherwise it is false, must be called each move
	 */
	private boolean isChecked(String[][] board){
		
		return true;
	}

}
