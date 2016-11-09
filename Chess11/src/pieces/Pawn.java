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
		
		int moveLength = Math.abs(Character.getNumericValue(src.charAt(1)) 
				- Character.getNumericValue(dest.charAt(1)));

		int col = Character.getNumericValue(src.charAt(0));
		int row = Character.getNumericValue(src.charAt(1));
		
		char playerColor = board[col][row].charAt(0);
		
		// Move 2 spaces on first turn
		if (moveLength > 1 && isFirstMove && (src.charAt(0) == dest.charAt(0))) {
			
			for (int i = row; i < (row + 2); i++) {
				// check board spaces in between if they are empty
				if (!board[col][row].isEmpty() && !board[col][row].contains("##")) {
					return false;
				}
			}

			isFirstMove = false;
			return true;

		} 
		// Normal one space forward move
		else if (moveLength == 1 && src.charAt(0) == dest.charAt(0)) {

			int columnToCheck;

			if (row > Character.getNumericValue(dest.charAt(1))) {
				columnToCheck = col--;
			} else {
				columnToCheck = col++;
			}
			// check space ahead if empty
			if (!board[columnToCheck][row].isEmpty() && !board[col][row].contains("##")) {
				return false;
			}
			
			isFirstMove = false;
			return true;
		}
		// Diagonal move to take opponent piece
		else if (moveLength == 1 && src.charAt(0) != dest.charAt(0)) {
			
			int colDiff = Math.abs(Character.getNumericValue(src.charAt(0)) 
					- Character.getNumericValue(dest.charAt(0)));

			// Check if destination is diagonal
			if (colDiff != 1) {
				return false;
			} else {
				
				int columnToCheck = Character.getNumericValue(dest.charAt(0));
				int rowToCheck = Character.getNumericValue(dest.charAt(1));
				
				CharSequence colorToCheck;
				if(playerColor == 'b'){
					colorToCheck = "w";
				} else {
					colorToCheck = "b";
				}
				
				if (!board[columnToCheck][rowToCheck].contains(colorToCheck)) {
					return false;
				} else {
					return true;
				}
			}


		}
		
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
