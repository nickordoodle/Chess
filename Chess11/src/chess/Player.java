/**
 * 
 */
package chess;

import pieces.Piece;

/**
 * @author Nick
 *
 */
public class Player implements PlayerAbilities {

	String name;
	char color;
	
	public Player(String name, char color) {
		this.name = name;
		this.color = color;
	}

	@Override
	public String[][] movePiece(String move, Piece piece, String[][] board) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String toString(){
		return null;
		
	}

}
