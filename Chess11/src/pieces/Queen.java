package pieces;

public class Queen extends Piece {

	public Queen(char color, char type) {
		super(color, type);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return super.toString();
	}
	
	public boolean isValidMove(String src, String dest, String[][] board) {
		
		return true;
	}

}
