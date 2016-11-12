package pieces;

public class Position {
	
	char column;
	int row;
	
	public Position(char column, int row){
		this.column = column;
		this.row = row;
	}
	
	
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
