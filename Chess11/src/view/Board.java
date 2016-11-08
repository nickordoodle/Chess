/**
 * 
 */
package view;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

/**
 * @author Nick
 *
 */
public class Board {

	
	/*
	 * May want to change type of array 
	 * to make it easier dealing with 
	 * simple ASCII values
	 */
	
	String[][] board;

	final int width = 9;
	final int height = 9;
	
	public Board(){
		
		board = createBoard();
		
	}
	
	private String[][] initBoard(String[][] board){
		
		for(int i = 0; i < board.length; i++){
			
			for(int a = 0; a < board.length; a++){
				board[i][a] = "";
			}
		}
		
		return board;
	}
	/*
	 * Used to initialize the board with all the 
	 * starting pieces in the correct place
	 */
	private String[][] createBoard(){

		//length is 9 each to account for drawing
		
		String[][] newBoard = new String[width][height];
		initBoard(newBoard);
		final char[] initialRowSet = {'R', 'N', 'B', 'Q', 'K',
				'B', 'N', 'R'};
	
		int COLVAL = 8;
		int ROWVAL = 97;
		
		//last column are numbers from 8...1
		//last row are lowercase letters from a..h
		//need to iterate through array and populate accordingly
		for(int i = 0; i < newBoard.length; i++){
				
			for (int a = 0; a < newBoard.length; a++){
				
				//sets the column values designated by letters
				if(a == 8 ){
					newBoard[i][a] = Integer.toString(COLVAL) + " ";
					COLVAL--;
				}
				//sets the row values going down on the right of board
				else if(i == 8){
					newBoard[i][a] = Character.toString((char) ROWVAL) + " ";
					ROWVAL++;
				} 
				//sets the top row and bottom row
				else if(i == 0 || i == 7){
					Piece newPiece = null;
					char color;
					
					if(i == 0){
						color = 'b';
					}
					else {
						color = 'w';
					}
					
					switch(initialRowSet[a]){	
						case 'R':
							newPiece = new Rook(color, 'R');
							newPiece.position.updatePosition((char)COLVAL, ROWVAL);
							break;
						case 'N':
							newPiece = new Knight(color, 'N');
							newPiece.position.updatePosition((char)COLVAL, ROWVAL);
							break;
						case 'B':
							newPiece = new Bishop(color, 'B');
							newPiece.position.updatePosition((char)COLVAL, ROWVAL);
							break;
						case 'Q':
							newPiece = new Queen(color, 'Q');
							newPiece.position.updatePosition((char)COLVAL, ROWVAL);
							break;
						case 'K':
							newPiece = new King(color, 'K');
							newPiece.position.updatePosition((char)COLVAL, ROWVAL);
							break;
			
					}
					
					if (newPiece == null){
						throw new NullPointerException();
					} else{
						newBoard[i][a] = newPiece.toString();
					}
					
				} else if (i == 1 || i == 6){
					char color;
					if(i == 1){
						color = 'b';
					} else {
						color = 'w';
					}
					
					Piece newPiece = new Pawn(color, 'p');
					newPiece.position.updatePosition((char)COLVAL, ROWVAL);
					newBoard[i][a] = newPiece.toString();
					
					
				} 

				//even row and odd col
				else if(i % 2 == 0 && a % 2 != 0 && newBoard[i][a].trim().length() == 0){
					newBoard[i][a] = "## ";
				} 
				//odd row and odd col
				else if (i % 2 != 0 && (a == 0 || a % 2 == 0 ) && newBoard[i][a].trim().length() == 0){
					newBoard[i][a] = "## ";
				}

			}
			
		}
		
		return newBoard;
	}
	
	
	/*
	 * Instance method to output the board to screen
	 */
	public void drawBoard(){
		
		for(int i = 0; i < board.length; i++){
			
			for(int a = 0; a < board.length; a++){
				String s = board[i][a];
				System.out.printf("%3s", s);
			}
			
			System.out.println();
		}
	}
	
	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

}
