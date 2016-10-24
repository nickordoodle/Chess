package pieces;

public class Position {


	private String pieceToMove;
	private String destination;
	
	public Position(String pieceToMove, String destination){
		this.pieceToMove = pieceToMove;
		this.destination = destination;
	}
	
	public String getPieceToMove() {
		return pieceToMove;
	}

	public void setPieceToMove(String pieceToMove) {
		this.pieceToMove = pieceToMove;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
}
