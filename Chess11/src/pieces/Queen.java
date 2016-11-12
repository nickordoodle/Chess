package pieces;

/**
 * @author Nick and Kartik
 *
 */
public class Queen extends Piece {

	/**
	 * Constructor for Queen
	 * 
	 * @param color
	 * @param type
	 */
	public Queen(char color, char type) {
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
		
		if (srcRow == dstRow) {
			
			if(srcCol > dstCol) {
				for(int i = srcCol-1; i > dstCol-1; i--) {
	
					// check if other pieces are in the way
					if (!board[srcRow][i].trim().equals("") && !board[srcRow][i].trim().equals("##")) {
						return false;
					}
				}
			} else {
				for(int i = srcCol+1; i < dstCol-1; i++) {
	
					// check if other pieces are in the way
					if (!board[srcRow][i].trim().equals("") && !board[srcRow][i].trim().equals("##")) {
						return false;
					}
				}
			}
			
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

		} else if (srcCol == dstCol) {
			
			if(color == 'w') {
				for(int i = srcRow-1; i > dstRow-1; i--) {
	
					// check if other pieces are in the way
					if (!board[i][srcCol].trim().equals("") && !board[i][srcCol].trim().equals("##")) {
						return false;
					}
				}
			} else {
				for(int i = srcRow+1; i < dstRow+1; i++) {
	
					// check if other pieces are in the way
					if (!board[i][srcCol].trim().equals("") && !board[i][srcCol].trim().equals("##")) {
						return false;
					}
				}
			}
			
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
			

		} else if(rowDist == colDist) {
			
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
						System.out.println(board[srcRow-i][srcCol-i]);
						if (!board[srcRow-i][srcCol-i].trim().equals("") && !board[srcRow-i][srcCol-i].trim().equals("##")) {
							return false;
						}
					}
				} else {
					for(int i = 1; i < rowDist; i++) {
						System.out.println(board[srcRow-i][srcCol+i]);
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
