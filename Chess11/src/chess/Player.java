/**
 * 
 */
package chess;

import java.util.ArrayList;

import pieces.Piece;

/**
 * @author Nick and Kartik
 *
 */
public class Player implements PlayerAbilities {

	String name;
	char color;
	ArrayList<Piece> playerPieces;
	
	/**
	 * Constructor for Player
	 * 
	 * @param name
	 * @param color
	 */
	public Player(String name, char color) {
		this.name = name;
		this.color = color;
		this.playerPieces = new ArrayList<Piece>();

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see chess.PlayerAbilities#movePiece(java.lang.String, pieces.Piece,
	 * java.lang.String[][])
	 * 
	 * Called when a piece is supposed to be move and works with the game board
	 * Returns the board 2d array once complete
	 * 
	 */

	@Override
	public String[][] movePiece(int srcRow, int srcCol, int dstRow, int dstCol, String extra, String[][] board) {
		Piece pieceToMove = null;
		for (int i = 0; i < playerPieces.size(); i++) {
			
			char col = (char) playerPieces.get(i).getPosition().getRow();
			int row = (int) playerPieces.get(i).getPosition().getColumn();
			/*
			 * find piece to move in players pieces
			 */
			if (row == srcRow && col == (char) srcCol) {
				pieceToMove = playerPieces.get(i);

				/* Selected piece is okay to move, update board and piece */
				if (pieceToMove.isValidMove(srcRow, srcCol, dstRow, dstCol, board)) {

					srcRow = (int) (Math.abs(srcRow - 8));
					srcCol = (int) (srcCol - 97);
					dstRow = (int) (Math.abs(dstRow - 8));
					dstCol = (int) (dstCol - 97);
					
					board[dstRow][dstCol] = pieceToMove.toString();
					board[srcRow][srcCol] = "";
					dstRow = (int) (Math.abs(dstRow - 8));
					System.out.println(srcRow + ", " + srcCol);
					if((srcRow + (srcCol-1)) % 2 == 0) {
						board[srcRow][srcCol] = "## ";
					}
					pieceToMove.getPosition().updatePosition(dstCol + 97, dstRow);
					if(pieceToMove.getType() == 'p') {
						if(pieceToMove.getPosition().getRow() == 0 && pieceToMove.getColor() == 'w') {
							pieceToMove.setType(extra.charAt(0));
						}
						if(pieceToMove.getPosition().getRow() == 7 && pieceToMove.getColor() == 'b') {
							pieceToMove.setType(extra.charAt(0));
						}
					}

				}
				/* The player did not select a valid move */
				else {
					System.out.println("Illegal move, try again");
					Chess.isBadMove = true;
				}
				pieceToMove.isFirstMove--;
			}
			

		}

		return board;
	}


	@Override
	public String toString(){
		return null;
		
	}
	/**
	 * 
	 * @return Player Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Player Color
	 */
	public char getColor() {
		return color;
	}

	/**
	 * 
	 * @param color
	 */
	public void setColor(char color) {
		this.color = color;
	}

	/**
	 * 
	 * @return ArrayList of Player Pieces
	 */
	public ArrayList<Piece> getPlayerPieces() {
		return playerPieces;
	}

	/**
	 * 
	 * @param playerPieces
	 */
	public void setPlayerPieces(ArrayList<Piece> playerPieces) {
		this.playerPieces = playerPieces;
	}

}
