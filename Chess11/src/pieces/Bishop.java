
package pieces;

/**
 * @author Nick and Kartik
 *
 */
public class Bishop extends Piece {
	
	/**
	 * Constructor for Bishop
	 * 
	 * @param color
	 * @param type
	 */
	public Bishop(char color, char type) {
		super(color, type);
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
		
		if(rowDist == colDist) {
			
			CharSequence colorToCheck;
			if(color == 'b'){
				if (srcCol > dstCol) {
					for(int i = 1; i < rowDist; i++) {
						if (!board[srcRow+i][srcCol-i].trim().equals("") && !board[srcRow+i][srcCol-i].trim().equals("##")) {
							return false;
						}
					}
				} else {
					for(int i = 1; i < rowDist; i++) {
						if (!board[srcRow+i][srcCol+i].trim().equals("") && !board[srcRow+i][srcCol+i].trim().equals("##")) {
							return false;
						}
					}
				}
				colorToCheck = "w";
			} else {
				if (srcCol > dstCol) {
					for(int i = 1; i < rowDist; i++) {
						if (!board[srcRow-i][srcCol-i].trim().equals("") && !board[srcRow-i][srcCol-i].trim().equals("##")) {
							return false;
						}
					}
				} else {
					for(int i = 1; i < rowDist; i++) {
						if (!board[srcRow-i][srcCol+i].trim().equals("") && !board[srcRow-i][srcCol+i].trim().equals("##")) {
							return false;
						}
					}
				}
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
