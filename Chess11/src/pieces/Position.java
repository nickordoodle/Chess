package pieces;

/**
 * @author Nick and Kartik
 *
 */
public class Position {
	
	char column;
	int row;
	
	/**
	 * Constructor for Position
	 * 
	 * @param column
	 * @param row
	 */
	public Position(char column, int row){
		this.column = column;
		this.row = row;
	}
	
	/**
	 * Update Position of the Piece
	 * 
	 * @param row
	 * @param col
	 */
	public void updatePosition(int row, int col){
		setColumn(col);
		setRow(row);
	}
	
	public char getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = (char) column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

}
