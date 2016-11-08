package chess;

import java.util.Scanner;

import view.Board;

public class Chess {

	private static String playerOneName;
	private static String playerTwoName;
	private static Scanner input;
	private static Board board;
	Player playerOne;
	Player playerTwo;
	
	private static void init(){
		final String enterNameMsg = "Please enter your name ";
		System.out.println(enterNameMsg);
		input = new Scanner(System.in);
		
		playerOneName = input.next();
		System.out.println("Welcome Player " + playerOneName);
		System.out.println(enterNameMsg + "player two");
		playerTwoName = input.next();
		System.out.println("Welcome Player " + playerTwoName);

		
	}
	
	private static boolean validateInput(char firstChar, char secondChar, int firstDigit, int secondDigit) {


		// check if initial letters are valid
		if (firstChar >= 97 && firstChar <= 104 && secondChar >= 97 && secondChar <= 104) {

			if (firstDigit >= 0 && firstDigit <= 8 && secondDigit >= 1 && secondDigit <= 8) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		int count = 0;
		boolean gameOver = false;
		boolean drawRequest = false;
		String moveString = "";
		String[] moveList = null;

		//start chess
		init();
		
		Player playerOne = new Player(playerOneName, 'b');
		Player playerTwo = new Player(playerTwoName, 'w');
		
		board = new Board();
		String[][] myBoard = board.getBoard();
		
		
		/*
		 * Basic turn based game engine
		 * 
		 * Handles overall game input/output, player moves,
		 * and game over.
		 * 
		 * Game over is defined by a player winning, draw, or 
		 * resign from a player
		 */
		
		System.out.println("Let the chess game begin!\n" + playerOne.name + " will "
				+ "go first.\n");
		
		// Initial Turn 
		board.drawBoard();
		System.out.print("Turn "+count+": \n" + (count % 2 == 0 ? playerOne.name : playerTwo.name) 
				+ "'s  move: ");
		moveString = input.nextLine();
		
		while(input.hasNextLine() && !gameOver){
			
			// Get the move
			moveString = input.nextLine();
			moveList = moveString.split(" ");
			
			// Check for Draw or Resigns
			if(moveList != null && moveList.length > 2) {
				if(moveList[2].equals("draw?")) {
					drawRequest = true;
					System.out.print("\n" + (count % 2 == 0 ? playerOne.name : playerTwo.name) 
							+ " has initiated a draw request.\n");
				}
			} else {
				if(moveList[0].equals("resign")) {
					gameOver = true;
					System.out.print("\n" + (count % 2 == 0 ? playerOne.name : playerTwo.name) 
							+ " has resigned from the match.");
					System.out.print("\n" + (count % 2 == 1 ? playerOne.name : playerTwo.name) 
							+ " wins the match!");
				} else if(moveList[0].equals("draw") && drawRequest) {
					gameOver = true;
					System.out.print("\n" + (count % 2 == 0 ? playerOne.name : playerTwo.name) 
							+ " has accepted the draw request.");
					System.out.print("\nThe match ends in a draw!");
				}
			 	drawRequest = false;				

			}
			
			// Prepare Next Turn
			
			if(!gameOver) {
				//Draw board 
				board.drawBoard();
			}
			else if(count % 2 == 0){
				System.out.println("Please enter your move player two.  You are white pieces.["
						+ playerTwo.name + "]");

				/*
				 * Check if piece is players piece Check if its on board
				 * 
				 * Get Piece, check if valid move for that piece
				 * 
				 * Get what first piece is, validate if it can go to the destination
				 * 97 - 97 + 8
				 */

				if (!validateInput(moveList[0].charAt(0), moveList[1].charAt(0), 
						moveList[0].charAt(1), moveList[1].charAt(1))) {
					System.out.println("Please enter valid input: [a-h][1-8] [a-h][1-8]\n");
					continue;
				}

				int firstIndex = (int) (moveList[0].charAt(0)) - 97;
				int secondIndex = (int) (Math.abs(moveList[0].charAt(1)) - 8);
				 
				String selectedPiece = myBoard[firstIndex][secondIndex];
				 
				
			} else{
				System.out.println("Please enter your move player one.  You are black pieces["
						+ playerOne.name + "]");

				/*
				 * 
				 * 
				 */

			}
				
				/*Then pick move according to player turn, use odd/even numbers
				* to indicate which player's turn it is.
				*/
				count++;	
				
				// Ask for move
				System.out.print("\n" + (count % 2 == 0 ? playerOne.name : playerTwo.name) 
						+ "'s  move: ");
			}			
			
			
			count++;
	
	}



}


