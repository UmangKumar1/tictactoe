/**
 * @author Umang Kumar
 *
 */
package TicTackToe;

import java.util.Scanner;

public class TicTacToe 
	{
	    public static void main(String[] args) 
		    {
	    			//Initialize the keep going variable(If it changes then then do while loop will stop)
	    			int keepGoing = 1;
	    			
	    			//initialize the two players names
	    			String p1;
	    			String p2;
	    			
	    			//these three counters will keep track of how many times you win, lose and draw
				int xWinCount = 0;
				int oWinCount = 0;
				int drawCount = 0;
				
				//initialize the scanner
				Scanner keyboard = new Scanner(System.in);
				
				//ask user 1 for their names
    				System.out.print("Name of Player 1: ");
				p1 = keyboard.nextLine();
				//Ask player 2 for their name
					System.out.print("Name of Player 2: ");
				p2 =  keyboard.nextLine();
				
				
				//basically loops the game until you dont want to play again.
		    		do {
		    			
					//initialize the O and X for the game
					char O = 'O';
					char X = 'X';
					//make an instance of the GameBoard 
		    			GameBoard mygame = new GameBoard();
		    			//counter to count how many times the do while loop happens
		    			int counter = 1;
		    			//calls the displayBoard on your my game object
		    			mygame.displayBoard();
		    			System.out.print("\n");
	
		    			// this while loop asks you which row and column you wish to put your perspective "token" 
		    			while(mygame.gameActive() && counter < 10) 
			    			{
		    				//changes the token value between O and X based on the counter value
			    				if (counter % 2 == 0) 
				    				{
				    					mygame.askPlayer(O);
				    				}
			    				else 
				    				{
				    					mygame.askPlayer(X);
				    				}
			    				counter++;
				    			System.out.print("\n");
				    			//calls for the display board class with the updated "tokens"
			    				mygame.displayBoard();
			    				//make sure that the game has not been won
			    				mygame.checkForWinner();
				    			
	
			    			}
		    				//keeps track of how many time O player has won
		    			if(counter %2 == 0 && counter <10) 
			    			{
			    				oWinCount++;
			    			}
		    				//keeps track of the times X player has won
		    			else if( counter % 2 == 1 && counter <10) 
			    			{
			    				xWinCount++;
			    			}
		    			//how many ties there have been
		    			if (counter == 10) 
	    				{
	    					System.out.println("");

	    					System.out.println("ITS A DRAW!!!!");
	    					drawCount++;
	    				}
		    			//prompts the user to play again
	    				System.out.print("Would you like to play again??(yes = 1 / no = 2)  ");
	    				int playAgain = keyboard.nextInt();
	    				//if the value is 2 then the keepGoing variable will change leading to stop in the do while loop
	    				if(playAgain == 2) 
		    				{
		    					keepGoing = 0;
		    				}
		    			
		    		} while ( keepGoing == 1);
		    		//once the loop is exited, print out how many time each player has won and how many time they draws
    				System.out.println(p1 + " won " + oWinCount + " times");
    				System.out.println(p2 + " won " + xWinCount + " times");
    				System.out.println("It was a draw " + drawCount + " times");

		    }
	}