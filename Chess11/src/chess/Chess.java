package chess;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import view.Board;

public class Chess {

	private static final Logger LOGGER = Logger.getLogger(Chess.class.getName());
	private static FileHandler fh;
	private static String playerOneName;
	private static String playerTwoName;
	private static Scanner input;
	private static Board board;
	public static boolean isBadMove = false;
	Player playerOne;
	Player playerTwo;
	

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
		
		board = new Board(playerOne, playerTwo);
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
		
		System.out.println("Let the chess game begin!\n" + playerOne.name + " is white and will "
				+ "go first.\n");
		
		// Initial Turn 
		board.drawBoard();
		System.out.println("Please enter your move " + playerOneName + ".  You are white.");
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
			}

			if (count % 2 == 0) {

				if (moveList.length < 2 || moveList[0].length() < 2 || moveList[1].length() < 2 || !validateInput(moveList[0].charAt(0), moveList[1].charAt(0),
						Character.getNumericValue(moveList[0].charAt(1)),
						Character.getNumericValue(moveList[1].charAt(1)))) {
					System.out.println("Please enter valid input: [a-h][1-8] [a-h][1-8]");
					continue;
				}

				int selectedRow = (int) (Math.abs((Character.getNumericValue(moveList[0].charAt(1))) - 8));
				int selectedCol = (int) (moveList[0].charAt(0)) - 97;

				int srcRow = (int) Character.getNumericValue(moveList[0].charAt(1));
				int srcCol = (int) moveList[0].charAt(0);

				int dstRow = (int) Character.getNumericValue(moveList[1].charAt(1));
				int dstCol = (int) moveList[1].charAt(0);
				
				String selectedPiece = board.getPiece(selectedRow, selectedCol);

				// check if user chose correct colored piece
				if (selectedPiece.trim().equals("") || selectedPiece.trim().equals("##")) {
					System.out.println("No piece at that position! Please select a piece:");
					continue;
				}
				
				if (selectedPiece.charAt(0) != 'w') {
					System.out.println("You are white! Please select your own pieces:");
					continue;
				}

				String[][] copy = playerOne.movePiece(srcRow, srcCol, dstRow, dstCol, myBoard);

				if (isBadMove) {
					isBadMove = false;
					continue;
				}
				
				for (int i = 0; i < copy.length; i++) {
					for (int a = 0; a < copy[i].length; a++) {
						myBoard[i][a] = copy[i][a];
					}
				}

				count++; board.drawBoard();
				System.out.println("Please enter your move " + playerTwoName + ".  You are black.");

			} else {

				if (moveList.length < 2 || moveList[0].length() < 2 || moveList[1].length() < 2 || !validateInput(moveList[0].charAt(0), moveList[1].charAt(0),
						Character.getNumericValue(moveList[0].charAt(1)),
						Character.getNumericValue(moveList[1].charAt(1)))) {
					System.out.println("Please enter valid input: [a-h][1-8] [a-h][1-8]");
					continue;
				}

				int selectedRow = (int) (Math.abs((Character.getNumericValue(moveList[0].charAt(1))) - 8));
				int selectedCol = (int) (moveList[0].charAt(0)) - 97;

				int srcRow = (int) Character.getNumericValue(moveList[0].charAt(1));
				int srcCol = (int) moveList[0].charAt(0);

				int dstRow = (int) Character.getNumericValue(moveList[1].charAt(1));
				int dstCol = (int) moveList[1].charAt(0);
				
				String selectedPiece = board.getPiece(selectedRow, selectedCol);
				
				// check if user chose correct colored piece
				if (selectedPiece.trim().equals("") || selectedPiece.trim().equals("##")) {
					System.out.println("No piece at that position! Please select a piece:");
					continue;
				}
				
				if (selectedPiece.charAt(0) != 'b') {
					System.out.println("You are black! Please select your own pieces:");
					continue;
				}

				String[][] copy = playerTwo.movePiece(srcRow, srcCol, dstRow, dstCol, myBoard);

				if (isBadMove) {
					isBadMove = false;
					continue;
				}
				
				for (int i = 0; i < copy.length; i++) {
					for (int a = 0; a < copy[i].length; a++) {
						myBoard[i][a] = copy[i][a];
					}
				}

				count++; board.drawBoard();
				System.out.println("Please enter your move " + playerOneName + ".  You are white.");

			}
			
		}
			
			
	
	}


	private static void createLog() {

		try {

			// This block configure the logger with handler and formatter
			fh = new FileHandler("C:/Users/Kartik/workspace/chesslog.log");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void init() {

		createLog();
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
		if (((int) firstChar) >= 97 && ((int) firstChar) <= 104 && ((int) secondChar) >= 97
				&& ((int) secondChar) <= 104) {
			if (firstDigit >= 1 && firstDigit <= 8 && secondDigit >= 1 && secondDigit <= 8) {
				return true;
				
				/* if (firstDigit == secondDigit && firstChar != secondChar) {
					return true;
				} else if (firstChar == secondChar && firstDigit != secondDigit) {
					return true;
				} */
			}
		}

		return false;
	}

}


