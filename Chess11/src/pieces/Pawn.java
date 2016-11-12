/**
 * 
 */
package pieces;

import java.util.logging.Logger;

/**
 * @author Nick
 *
 */
public class Pawn extends Piece {

	private boolean isPromoted;
	private static final Logger LOGGER = Logger.getLogger(Pawn.class.getName());

	public Pawn(char color, char type) {
		super(color, type);
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

	public boolean isValidMove(int srcRow, int srcCol, int dstRow, int dstCol, String[][] board) {
		
		int moveLength = dstRow - srcRow;
		System.out.println("MOVELENGTH " + moveLength);

		srcRow = (int) (Math.abs(srcRow - 8));
		srcCol = (int) (srcCol - 97);
		dstRow = (int) (Math.abs(dstRow - 8));
		dstCol = (int) (dstCol - 97);
		
		String piece = board[srcRow][srcCol];
		char playerColor = piece.charAt(0);
		
		// Move 2 spaces on first turn
		if (moveLength > 1 && isFirstMove > 0 && (srcCol == dstCol)) {
			if(color == 'w') {
				for (int i = srcRow - 1; i >= (srcRow - 2); i--) {
					// check board spaces in between if they are empty
					System.out.println(board[i][srcCol]);
					if (!board[i][srcCol].trim().equals("") && !board[i][srcCol].trim().equals("##")) {
						return false;
					}
				}
			} else {
				for (int i = srcRow + 1; i >= (srcRow + 2); i++) {
					// check board spaces in between if they are empty
					System.out.println(board[i][srcCol]);
					if (!board[i][srcCol].trim().equals("") && !board[i][srcCol].trim().equals("##")) {
						return false;
					}
				}
			}

			return true;

		} 
		// Normal one space forward move
		else if (moveLength == 1 && srcCol == dstCol) {
System.out.println("ONE FORWARD");
			int rowToCheck;

			if (color == 'w') {
				rowToCheck = srcCol - 1;
			} else {
				rowToCheck = srcCol + 1;
			}
			// check space ahead if empty
			System.out.println(board[rowToCheck][srcCol]);
			if (!board[rowToCheck][srcCol].trim().equals("") && !board[rowToCheck][srcCol].trim().equals("##")) {
				return false;
			}
			
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
				
				if (!board[dstRow][dstCol].contains(colorToCheck)) {
					return false;
				} else {
					return true;
				}
			}


		}
		
		return true;
	}

	public boolean isPromoted() {
		return isPromoted;
	}

	public void setPromoted(boolean isPromoted) {
		this.isPromoted = isPromoted;
	}

}
