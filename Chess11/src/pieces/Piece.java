package pieces;

public abstract class Piece {
	
	private char color;
	private char type;
	public Position position;
	
	public Piece(char color, char type){
		this.color = color;
		this.type = type;
		this.position = new Position('a', 1);
	}

	public String toString(){
		return Character.toString(color) + Character.toString(type) + " ";
	}
	
	public abstract boolean isValidMove(String move, String[][] board);
	
}
