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
		return false;
	
	/*	
		// check the range between src and dest for no other pieces

		// check for different numbers
		if (src.charAt(0) == dest.charAt(0)) {

			String temp = src;
			int digit = Character.getNumericValue(temp.charAt(1));
			int letter = Character.getNumericValue(temp.charAt(0));

			while (!temp.equals(dest)) {

				// check if other pieces are in the way
				if (board[letter][digit] != "##" || !board[letter][digit].isEmpty()) {
					return false;
				}

				// increment digit or decrement digit based on direction
				if (Character.getNumericValue(dest.charAt(1)) > digit) {
					digit++;
				} else {
					digit--;
				}

				String newString = temp.substring(0, 0) + digit;
				temp = newString.substring(0, newString.length());

			}

			return true;

		} else if (src.charAt(1) == dest.charAt(1)) {

			// check for different letters
			String temp = src;
			int digit = Character.getNumericValue(temp.charAt(1));
			int letter = Character.getNumericValue(temp.charAt(0));

			while (!temp.equals(dest)) {

				// check if other pieces are in the way
				if (board[letter][digit] != "##" || !board[letter][digit].isEmpty()) {
					return false;
				}

				// increment or decrement letter
				if (Character.getNumericValue(dest.charAt(0)) > letter) {
					letter++;
				} else {
					letter--;
				}

				String newString = letter + temp.substring(1, 1);
				temp = newString.substring(0, newString.length());

			}

			return true;

		} else {

			return false;
		}
*/
	}

}
