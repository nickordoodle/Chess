/**
 * 
 */
package chess;

import java.util.ArrayList;
import java.util.logging.Logger;

import pieces.Piece;

/**
 * @author Nick
 *
 */
public class Player implements PlayerAbilities {

	private static final Logger LOGGER = Logger.getLogger(Player.class.getName());
	String name;
	char color;
	ArrayList<Piece> playerPieces;
	
	public Player(String name, char color) {
		this.name = name;
		this.color = color;
		this.playerPieces = new ArrayList<Piece>();
		LOGGER.info("Creating a new player");

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
	public String[][] movePiece(int srcRow, int srcCol, int dstRow, int dstCol, String[][] board) {
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
					pieceToMove.getPosition().updatePosition(dstCol + 97, dstRow);

				}
				/* The player did not select a valid move */
				else {
					System.out.println("Illegal move, please enter a valid move: ");
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public ArrayList<Piece> getPlayerPieces() {
		return playerPieces;
	}

	public void setPlayerPieces(ArrayList<Piece> playerPieces) {
		this.playerPieces = playerPieces;
	}

}
