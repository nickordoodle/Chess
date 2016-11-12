package pieces;

public abstract class Piece {
	
	protected char color;
	private char type;
	public Position position;
	public int isFirstMove = 2;
	
	public Piece(char color, char type){
		this.color = color;
		this.type = type;
		this.position = new Position('a', 1);
	}

	public String toString(){
		return Character.toString(color) + Character.toString(type) + " ";
	}
	
	// Implemented for each piece
	public abstract boolean isValidMove(int srcRow, int srcCol, int dstRow, int dstCol, String[][] board);


	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
