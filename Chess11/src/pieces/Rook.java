package pieces;

public class Rook extends Piece {

	public Rook(char color, char type) {
		super(color, type);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return super.toString();
	}
	public boolean isValidMove(int srcRow, int srcCol, int dstRow, int dstCol, String[][] board) {

		srcRow = (int) (Math.abs(srcRow - 8));
		srcCol = (int) (srcCol - 97);
		dstRow = (int) (Math.abs(dstRow - 8));
		dstCol = (int) (dstCol - 97);

		// check for different numbers
		if (srcRow == dstRow) {

			for(int i = srcCol; i < dstCol; i++) {

				// check if other pieces are in the way
				if (!board[srcRow][i].trim().equals("") && !board[i][srcCol].trim().equals("##")) {
					return false;
				}
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

		} else if (srcCol == dstCol) {

			for(int i = srcRow; i < dstRow; i++) {

				// check if other pieces are in the way
				if (!board[i][srcCol].trim().equals("") && !board[srcRow][i].trim().equals("##")) {
					return false;
				}
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

		} else {

			return false;
		}
	}

}
