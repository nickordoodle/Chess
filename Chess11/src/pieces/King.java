package pieces;

/**
 * @author Nick and Kartik
 *
 */
public class King extends Piece {

	/**
	 * Constructor for King
	 * 
	 * @param color
	 * @param type
	 */
	public King(char color, char type) {
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

		int rowDist = Math.abs(dstRow - srcRow);
		int colDist = Math.abs(dstCol - srcCol);
		

		srcRow = (int) (Math.abs(srcRow - 8));
		srcCol = (int) (srcCol - 97);
		dstRow = (int) (Math.abs(dstRow - 8));
		dstCol = (int) (dstCol - 97);
		// 1 step movement
		if((rowDist == 1 && colDist == 0) || (rowDist == 0 && colDist == 1) || (rowDist == 1 && colDist == 1) ) {
			
			if (board[dstRow][dstCol].trim().equals("") || board[dstRow][dstCol].trim().equals("##")) {
				return true;
			}
			
			CharSequence colorToCheck;
			if(color == 'b'){
				colorToCheck = "w";
			} else {
				colorToCheck = "b";
			}
			
			if (!board[dstRow][dstCol].contains(colorToCheck)) {
				return false;
			} else {
				return true;
			}
			
		}
		// castling movement
		else if(colDist == 2) {
			if(color == 'w' && srcRow == 7 && srcCol == 4 && dstRow == 7 && dstCol == 6 && board[7][7].trim().equals("wR")) {
				for (int i = srcCol + 1; i <= (srcCol + 2); i++) {
					// check board spaces in between if they are empty
					if (!board[srcRow][i].trim().equals("") && !board[srcRow][i].trim().equals("##")) {
						return false;
					}
				}
				return true;
			}
			if(color == 'b' && srcRow == 0 && srcCol == 4 && dstRow == 0 && dstCol == 6 && board[0][0].trim().equals("bR")) {
				for (int i = srcCol + 1; i <= (srcCol + 2); i++) {
					// check board spaces in between if they are empty
					if (!board[srcRow][i].trim().equals("") && !board[srcRow][i].trim().equals("##")) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	

}
