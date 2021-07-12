/**
 * 
 */
package chess;

import java.util.ArrayList;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

/**
 * @author Nick and Kartik
 *
 * Player Object for Chess Game
 *
 */
public class Player implements PlayerAbilities {

	String name;
	char color;
	ArrayList<Piece> playerPieces;
	Player opponent = null;
	
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
					if((srcRow + (srcCol-1)) % 2 == 0) {
						board[srcRow][srcCol] = "## ";
					}
					pieceToMove.getPosition().updatePosition(dstCol + 97, dstRow);
					
					// Castling rook
					for (int j = 0; j < playerPieces.size(); j++) {
						
						char col2 = (char) playerPieces.get(j).getPosition().getRow();
						int row2 = (int) playerPieces.get(j).getPosition().getColumn();
						
						if (pieceToMove.getType() == 'K' && pieceToMove.getColor() == 'w' && row2 == 1 && col2 == (char) 104) {
							Piece piece = playerPieces.get(j);
							board[7][5] = piece.toString();
							board[7][7] = "";
							piece.getPosition().updatePosition(7, 102);
						}
						
						if (pieceToMove.getType() == 'K' && pieceToMove.getColor() == 'b' && row2 == 8 && col2 == (char) 104) {
							Piece piece = playerPieces.get(j);
							board[0][5] = piece.toString();
							board[0][7] = "## ";
							piece.getPosition().updatePosition(0, 102);
						}
					}
					
					// Promote pawn
					if(pieceToMove.getType() == 'p') {
						if((dstRow == 8 && pieceToMove.getColor() == 'w') || (dstRow == 1 && pieceToMove.getColor() == 'b')) {
							switch(extra.charAt(0)){	
								case 'R':
									pieceToMove = new Rook(pieceToMove.getColor(), 'R');
									break;
								case 'N':
									pieceToMove = new Knight(pieceToMove.getColor(), 'N');
									break;
								case 'B':
									pieceToMove = new Bishop(pieceToMove.getColor(), 'B');
									break;
								case 'Q':
									pieceToMove = new Queen(pieceToMove.getColor(), 'Q');
									break;
								case 'K':
									pieceToMove = new King(pieceToMove.getColor(), 'K');
									break;
					
							}
							if(pieceToMove.getColor() == 'w') {
								pieceToMove.position.updatePosition((int) col, row+1);
							} else {
								pieceToMove.position.updatePosition((int) col, row-1);
							}
							board[(Math.abs(dstRow - 8))][dstCol] = pieceToMove.toString();
							playerPieces.set(i, pieceToMove);
						}
					}
					
					
					// Remove opponent piece
					for (int j = 0; j < opponent.getPlayerPieces().size(); j++) {
						
						char col2 = (char) opponent.getPlayerPieces().get(j).getPosition().getRow();
						int row2 = (int) opponent.getPlayerPieces().get(j).getPosition().getColumn();
						
						if (row2 == dstRow && col2 == (char) (dstCol + 97)) {
							opponent.getPlayerPieces().remove(j);	
						}
					}

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
	
	public boolean detectCheck(String[][] board, boolean player) {
		// boolean player: true = white, false = black
		
		int kingRow = 0; int kingCol = 0;
		
		if(player) {
			// find black King Location
			for(int i=0; i < board.length; i++) {
				for(int j=0; j < board[0].length; j++) {
					if(board[i][j].trim().equals("bK")) {
						kingRow = i;
						kingCol = j;
					}
				}
			}
			
		} else {
			// find white King Location
			for(int i=0; i < board.length; i++) {
				for(int j=0; j < board[0].length; j++) {
					if(board[i][j].trim().equals("wK")) {
						kingRow = i;
						kingCol = j;
					}
				}
			}
		}
		
		Piece king = null;
		for (int i = 0; i < opponent.getPlayerPieces().size(); i++) {
			char col = (char) opponent.getPlayerPieces().get(i).getPosition().getRow();
			int row = (int) opponent.getPlayerPieces().get(i).getPosition().getColumn();
			if (row == Math.abs(kingRow-8) && col == (char) (kingCol + 97)) {
				king = opponent.getPlayerPieces().get(i);
				break;
			}
		}
		boolean checkMate = true;
		boolean check = false;
		for(int i = -1; i <= 1; i++){
			for(int j = -1; j <= 1; j++){
				int newRow = kingRow + i;
				int newCol = kingCol + j;
				if((i == 0 && j == 0)
				|| Math.abs(newRow-8) > 0 && Math.abs(newRow-8) < 9 && newCol >= 0 && newCol < 8 &&
				king.isValidMove(king.getPosition().getColumn(), king.getPosition().getRow(), Math.abs(newRow - 8), newCol + 97, board)){
					boolean canMoveHere = true;
					for(Piece piece : playerPieces){
						if(piece.isValidMove(piece.getPosition().getColumn(), piece.getPosition().getRow(), Math.abs(newRow - 8), newCol + 97, board)){
							canMoveHere = false;
							check = true;
						}
					}
					if(canMoveHere) checkMate = false;
				}
			}
		}
		if(checkMate) {
			System.out.println("Checkmate");
		} else if(check) {
			System.out.println("Check");
		}
		return checkMate;
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
	
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}

}
