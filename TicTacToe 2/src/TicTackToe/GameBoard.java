package TicTackToe;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard 
	{
		//initialze the first two dimensional array
		private char [][] gameBoard;
		//this variable makes sure the game is still going on
		private boolean isGameOnGoing = true;
		//this is the constructor for the game board
		public GameBoard() 
			{
				//make the 3 by 3 format for the tic tac toe
				gameBoard= new char[3][3];
				//this for loop fills the array with empty spaces so we know if there is ever an empty space
				for(int i=0; i<3; i++) 
					{
						Arrays.fill(gameBoard[i], ' ');
					}
			}
		//this will allow me to show me the board
		public void displayBoard()
			{
				
				for(int row=0; row<3; row++) 
					{
						for(int column=0; column<3; column++) 
							{
								System.out.print("\t" + gameBoard[row][column]);
								if(column == 0 || column == 1) 
									{
										//allows there to be a vertical line in the columns
										System.out.print("|");
									}
								
							}
						//allows the board to have the 2 horizontal lines
						if(row == 0 || row == 1) 
						{
							System.out.println("\n----------------------------\n");
						}


					}
			}
		
		public boolean makeMove (char player, int row, int column) 
			{
				//checks to make sure that you have between 1-3 rows and columns
				if(row>= 0 && row <= 2 && column >= 0 && column <= 2) 
					{
						//
						if (gameBoard[row][column] != ' ') 
							{
								return true;
							}
						else 	
							{
								gameBoard[row][column] = player;
								return true;
							}
					}
				return false;
			}
		public boolean gameActive() 
			{
				//returns true/false to keep the game going or end it
				return isGameOnGoing;
			}
		//this asks the player where they would liek to put their toke
		public void askPlayer (char player) 
			{
				//initalize the row and column they will choos
				int row;
				int column;
				Scanner keyboard = new Scanner(System.in);
				//this do while loop keeps looping until 
				do {
					System.out.println(' ');

					System.out.printf("Player %s , PLease enter a row(1-3): ", player );
						row = keyboard.nextInt();
					System.out.printf("Player %s , PLease enter a column(1-3): ", player);
						column =keyboard.nextInt();
					
					
					}while(notValid(row,column));
				
				makeMove(player,row-1,column-1);
			}
		
		public boolean notValid (int row, int col) 
			{
					if(row >3 || row <0 || col>3 || col<0 || !isEmpty(row, col)) 
						{
							return true;
						}
			
			return false;
			
			}
		//chekcs if the spot is empty and if it is not returns a message
		public boolean isEmpty(int row, int column) 
			{
				if(gameBoard[row-1][column-1] == ' ') 
					{
						return true;
					}
				else 
					{
						System.out.println("That position is already taken!\n");
						return false;
		
					}
			}
		//checks for a winner every turn
		public boolean checkForWinner() 
			{
				//this makes sure that there isn't three in a row in one of the rows
				for( int row = 0; row<3; row++) 
					{
						if(gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2] && gameBoard[row][0] != ' ') 
							{					
								System.out.println(' ');
								System.out.println("The winner is: " + gameBoard[row][0]);
								isGameOnGoing = false;							
							}
					}
				
				//this makes sure that there isn't three in a row in one of the columns
				for(int col = 0; col <3; col++) 
					{
						if(gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col] && gameBoard[0][col] != ' ') 
							{
								System.out.println(' ');
								System.out.println("The winner is: " + gameBoard[col][0]);
								isGameOnGoing = false;							
							}
					}
				//diagonals 
				if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ')
					{	
						System.out.println(' ');
						System.out.println("The winner is: " + gameBoard[0][0]);
						isGameOnGoing = false;							
					}
					
				if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] && gameBoard[0][2] != ' ')
					{
						System.out.println(' ');
						System.out.println("The winner is: " + gameBoard[1][1]);
						isGameOnGoing = false;							
					}
				
				return false;
			}
			
		
	}
