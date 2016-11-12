
package pieces;


/**
 * @author Nick and Kartik
 *
 */
public class Knight extends Piece {

	/**
	 * Constructor for Knight
	 * 
	 * @param color
	 * @param type
	 */
	public Knight(char color, char type) {
		super(color, type);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return super.toString();
	}


	/* (non-Javadoc)
	 * @see pieces.Piece#isValidMove()
	 */
	public boolean isValidMove(int srcRow, int srcCol, int dstRow, int dstCol, String[][] board) {

		srcRow = (int) (Math.abs(srcRow - 8));
		srcCol = (int) (srcCol - 97);
		dstRow = (int) (Math.abs(dstRow - 8));
		dstCol = (int) (dstCol - 97);

		int rowDist = Math.abs(dstRow - srcRow);
		int colDist = Math.abs(dstCol - srcCol);
		
		if((rowDist == 2 && colDist == 1) || (rowDist == 1 && colDist == 2)) {
			
			CharSequence colorToCheck;
			if(color == 'b'){
				colorToCheck = "w";
			} else {
				colorToCheck = "b";
			}
			
			if (!board[dstRow][dstCol].contains(colorToCheck) && !board[dstRow][dstCol].trim().equals("") && !board[dstRow][dstCol].trim().equals("##")) {
				return false;
			} else {
				return true;
			}
			
		} else {
			return false;
		}
		
	}

}
