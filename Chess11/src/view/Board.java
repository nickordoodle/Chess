/**
 * 
 */
package view;

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
	
	
	/*
	 * Used to initialize the board with all the 
	 * starting pieces in the correct place
	 */
	private String[][] createBoard(){

		//length is 9 each to account for drawing
		
		String[][] newBoard = new String[width][height];
		
	
		/*need to iterate through array and populate accordingly
		for(int i = 0; i < newBoard.length; i++){
			
			for (int a = 0; a < newBoard.length; a++){
				//add values
			}
			
		}
		*/
		
		return newBoard;
	}

}
