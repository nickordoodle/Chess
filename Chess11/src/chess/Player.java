/**
 * 
 */
package chess;

import java.util.ArrayList;

import pieces.Piece;

/**
 * @author Nick
 *
 */
public class Player implements PlayerAbilities {

	String name;
	char color;
	ArrayList<Piece> playerPieces;
	
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
	public String[][] movePiece(String src, String dest, String[][] board) {

		Piece pieceToMove = null;

		for (int i = 0; i < playerPieces.size(); i++) {

			char col = playerPieces.get(i).getPosition().getColumn();
			int row = playerPieces.get(i).getPosition().getRow();

			/*
			 * find piece to move in players pieces
			 */
			if (Character.getNumericValue(col) == src.charAt(0) && row == Character.getNumericValue(src.charAt(1))) {
				pieceToMove = playerPieces.get(i);

				/* Selected piece is okay to move, update board and piece */
				if (pieceToMove.isValidMove(src, dest, board)) {

					board[Character.getNumericValue(dest.charAt(0))][Character
							.getNumericValue(dest.charAt(1))] = pieceToMove.toString();
					pieceToMove.getPosition().updatePosition(dest.charAt(0), Character.getNumericValue(dest.charAt(1)));

				}
				/* The player did not select a valid move */
				else {
					System.out.println("Illegal move, try again");
					Chess.isBadMove = true;
				}
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
