
package pieces;

/**
 * @author Nick and Kartik
 *
 */
public class Pawn extends Piece {

	private boolean isPromoted;
 	private boolean isFirstMove;

	/**
	 * Constructor for Pawn
	 * 
	 * @param color
	 * @param type
	 */
	public Pawn(char color, char type) {
		super(color, type);
 		isFirstMove = true;
	}

	public String toString(){
		return super.toString();
	}

	/* (non-Javadoc)
	 * @see pieces.Piece#isValidMove()
	 */
	public boolean isValidMove(int srcRow, int srcCol, int dstRow, int dstCol, String[][] board) {
		
		int moveLength = Math.abs(dstRow - srcRow);

		srcRow = (int) (Math.abs(srcRow - 8));
		srcCol = (int) (srcCol - 97);
		dstRow = (int) (Math.abs(dstRow - 8));
		dstCol = (int) (dstCol - 97);
		
		String piece = board[srcRow][srcCol];
		char playerColor = piece.charAt(0);
		
		// Move 2 spaces on first turn
		if (moveLength == 2 && isFirstMove && (srcCol == dstCol)) {
			if(color == 'w') {
				for (int i = srcRow - 1; i >= (srcRow - 2); i--) {
					// check board spaces in between if they are empty
					if (!board[i][srcCol].trim().equals("") && !board[i][srcCol].trim().equals("##")) {
						return false;
					}
				}
			} else {
				for (int i = srcRow + 1; i >= (srcRow + 2); i++) {
					// check board spaces in between if they are empty
					if (!board[i][srcCol].trim().equals("") && !board[i][srcCol].trim().equals("##")) {
						return false;
					}
				}
			}

 			isFirstMove = false;
			return true;

		} 
		// Normal one space forward move
		else if (moveLength == 1 && srcCol == dstCol) {
			int rowToCheck;

			if (color == 'w') {
				rowToCheck = srcRow - 1;
			} else {
				rowToCheck = srcRow + 1;
			}
			// check space ahead if empty
			if ((color == 'w' && dstRow > srcRow) || (color == 'b' && dstRow < srcRow) || (!board[rowToCheck][srcCol].trim().equals("") && !board[rowToCheck][srcCol].trim().equals("##"))) {
				return false;
			}
 			isFirstMove = false;
			return true;
		} 
		// Diagonal move to take opponent piece
		else if (moveLength == 1 && srcCol != dstCol) {
			
			int colDiff = Math.abs(srcCol - dstCol);

			// Check if destination is diagonal
			if (colDiff != 1) {
				return false;
			} else {
				
				CharSequence colorToCheck;
				if(playerColor == 'b'){
					colorToCheck = "w";
				} else {
					colorToCheck = "b";
				}
				
				boolean enpassant = false;
				if(color == 'w' && board[dstRow+1][dstCol].trim().equals("bp")) {
					if((dstRow + 1 + (dstCol-1)) % 2 == 0) {
						board[dstRow+1][dstCol] = "## ";
					} else {
						board[dstRow+1][dstCol] = "";
					}
					enpassant = true;
				}
				if(color == 'b' && board[dstRow-1][dstCol].equals("wp")) {
					if((dstRow - 1 + (dstCol-1)) % 2 == 0) {
						board[dstRow-1][dstCol] = "## ";
					} else {
						board[dstRow+1][dstCol] = "";
					}
				}

				if (!board[dstRow][dstCol].contains(colorToCheck) && !enpassant) {
					return false;
				} else {
					isFirstMove = false;
					return true;
				}
			}


		}

		return false;
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
