

import java.util.Scanner;


/**
 * 
 * @author Paul A. Mould
 *PaThis is the main program that will use the Game class to play tic-tac-toe
 */
public class GamePlayer {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("X Player: ");
		String player1 = in.next();
		System.out.println("O Player: ");
		String player2 = in.next();
		
		if(player1.equalsIgnoreCase(player2))
		{
			player1= "X";
		    player2= "O";
		}
		
		System.out.println("Dimensions ");
		int dim = in.nextInt();
		Game NewGame = new Game(player1,player2,dim );
		boolean done = false;
		
		System.out.println("Enter a move or\n      S - to show the game board\n" +
			    "      Q - to quit\n" +
			    "      U - to undo the last move\n" +
			    "      I - to see these instructions");
		while(!done)
		{
		
			System.out.println(NewGame.nextPlayer()+ " 's turn ");
			System.out.println("Which row? (1 to "+dim+")");
		
			if (in.hasNextInt())
			{
				int row = in.nextInt()-1;
				
				System.out.println("Which column? (1 to "+dim+")");
				int col = in.nextInt()-1;
				
				NewGame.makeMove(row, col);
				
				if(NewGame.winner().equalsIgnoreCase(player1))
				{
				System.out.println(" Game is over, "+ player1+" is the winner");
				System.out.println(NewGame.toString());
				done = true;

				}
				else if(NewGame.winner().equalsIgnoreCase(player2))
				{
				System.out.println(" Game is over, "+ player2+" is the winner");
				System.out.println(NewGame.toString());
				done = true;
				}
				else if(NewGame.makeMove(row, col)==true)
				System.out.println(" that is not a valid move ");

				else if(NewGame.full()==true)
				{
				System.out.println(" Game is over, there is no winner");
				done= true;
				}

				}
			else{

				char choice = in.next().charAt(0);	
				switch (choice)
				{
					case 'S': System.out.println(NewGame.toString());
					break;
					case 'Q': done =true;
					System.out.println("The Game ");
					break;
					case 'U':NewGame.undo();
					break;
					case 'I': instructions();
					break;
				
				
				}
			}
		}
	}
				
		/**
		 * This method displays the set of instructins for the tic-tac-toe game	
		 */
		private static void  instructions()
		{ System.out.println("Enter a move or\n      S - to show the game board\n" +
			    "      Q - to quit\n" +
			    "      U - to undo the last move\n" +
			    "      I - to see these instructions");
    	
    	System.out.println("INSTRUCTIONS\n" +
				   "The Players would place X's and O's on to the board one at a time until " +
				 "\none player wins or when the board is empty " +
				 "\nor until somebody gets a line of X's or O's across the entire board ");
			
		}
			
		
		
	
}	
	

