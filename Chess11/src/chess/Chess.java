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
	
	public static void main(String[] args) {

		int count = 0;
		boolean gameOver = false;

		//start chess
		init();
		
		Player playerOne = new Player(playerOneName);
		Player playerTwo = new Player(playerTwoName);
		
		board = new Board();
		
		/*
		 * Basic turn based game engine
		 * 
		 * Handles overall game input/output, player moves,
		 * and game over.
		 * 
		 * Game over is defined by a player winning, draw, or 
		 * resign from a player
		 */
		
		System.out.println("Let the chess game begin! Player One will "
				+ "go first. Please enter your move.");
		
		while(input.hasNext() && !gameOver){
			
			//Draw board at beginning of each turn
			
			
			/*Then pick move according to player turn, use odd/even numbers
			* to indicate which player's turn it is.
			*/
			if(count == 0){
				count++;
				continue;
			}
			else if(count % 2 == 0){
				System.out.println("Please enter your move player two["
						+ playerTwo.name + "]");
			} else{
				System.out.println("Please enter your move player one["
						+ playerOne.name + "]");
			}
				
			
			String move = input.next();
			
			
			
			
			count++;
			
		}
		


	}

}
