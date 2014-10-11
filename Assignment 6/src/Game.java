import java.util.ArrayList;



/**
 * CSC 204: Programming Assginment 6: Tic-Tac-Toe
 * @author Paul A. Mould
 *This class will handle the mechanics of tic-tac-toe a game. 
 */

public class Game {
	
	private String [][] board;
	private String playerOne;
	private String playerTwo, moves;
	private int size;
	int arraySize = 0;
	private int count = (int)(Math.random()*2);
	private ArrayList<Integer> tracker = new ArrayList<Integer> ();

	/** Game constructor that has three parameters
	 *
	 * @param PlayerX a String representing the name of player "X" 
	 * @param PlayerO a String representing the name of player "O" 
	 * @param dim an integer representing the number of rows and columns of the board
	 */
	public Game(String PlayerX, String PlayerO,int dim)
	{
			if(dim<3)
			dim=3;
			else if (dim>10)
			dim=10;
			size=dim;
			playerOne = PlayerX;
			playerTwo = PlayerO;
			board = new String[dim][dim];
			

			
			for(int i = 0;i<dim;i++)
			{	for(int j = 0;j<dim;j++)
				{
				board[i][j]= " ";
				}
				
			}
				}
	/**
	 * Game constructor that has two parameters
	 * @param NameOne String representing the name of player "X"
	 * @param NameTwo a String representing the name of player "O"
	 */
	public Game(String NameOne,String NameTwo)
	{
		playerOne = NameOne;
		playerTwo = NameTwo;
		board = new String[size][size];
		size = 3;
		for(int i = 0;i<size;i++)
		{	for(int j = 0;j<size;j++)
			{
			board[i][j]= " ";
			}
		}
			
	}

	/** This method will check who is the winner of the game and will return 
	 * the name of the winner or if there is no winner it will return an empty String.
	 * @return the name of the winner or an empty String if there is no winner.
	 */
	public String winner()
	{
		int CountXrow = 0; int CountOrow = 0;
		int CountOcol = 0; int CountXcol = 0; 
		int CountOdiag1 = 0; int CountXdiag1 = 0;
	    int CountOdiag2 = 0; int CountXdiag2 = 0;
	    
	    //Cheeking for a row winner
		for(int a = 0;a < board.length;a++)
		{
			for(int b = 0;b < board.length;b++ )
			{
				if((board[a][b]).equalsIgnoreCase("X"))
					
					CountXrow++;
					if(CountXrow ==size)
						return playerOne;
				
				else if((board[a][b]).equalsIgnoreCase("O"))
					CountOrow++;
					if (CountOrow ==size)
						return playerTwo;
				
			}
			CountXrow=0;CountOrow=0;
		}
		
		//Checking for a column winner 
		for(int a = 0;a < board.length;a++)
		{
			for(int b = 0;b < board.length;b++ )
			{
				if((board[b][a]).equalsIgnoreCase("X"))
					CountXcol++;
					if(CountXcol ==size)
						return playerOne;
				
				else if((board[b][a]).equalsIgnoreCase("O"))
					CountOcol++;
					if (CountOcol ==size)
						return playerTwo;
				
			}
			CountXcol=0;CountOcol=0;
		}
		
		//Checking for a diagonal downward winner
			for(int b = 0;b < board.length;b++ )
			{
				if((board[b][b]).equalsIgnoreCase("X"))
				{	CountXdiag1++;
					if(CountXdiag1==size)
						return playerOne+"dwx";
				}
				else if((board[b][b]).equalsIgnoreCase("O"))
					CountOdiag1++;
					if(CountOdiag1==size)
						return playerTwo+"dwo";
					
			}
		
		
		//Checking for a diagonal upward winner
			for(int b = 0;b < board.length;b++ )
			{
				if((board[b][board.length-b-1]).equalsIgnoreCase("X"))
				{	CountXdiag2++;
					if(CountXdiag2==size)
						return playerOne;
				}
				else if((board[b][b]).equalsIgnoreCase("O"))
					CountOdiag2++;
					if(CountOdiag2==size)
						return playerTwo;
				
			}
		return " ";
	}

	/** This method alternates the movement of the players.
	 *
	 * @return the next player to make a moves.
	 */
	public String nextPlayer()
	{ 	
		/**if (count %2 ==0)
			return playerTwo;
			return playerOne;
	**/
		if (count %2 ==0)
			moves=playerOne;
		else
			moves= playerTwo;
		return moves;
	}
	
	private String nextPlayerMark(){
		if(count%2==0)
		return "X";
		else
		return "O";
		}

		/** This method allows you to make a moves if it is valid, and change the next player.
		*
		* @param row an integer representing the row on which you want to moves.
		* @param col an integer representing the column on which you want to moves.
		* @return true if the moves if
		*/
		public boolean makeMove( int row, int col)
		{
		if((row >=0&&row<size)&&(col>=0&&col<size))
			if(board[row][col].equals(" "))
		{
		board[row][col] = (nextPlayerMark());
		count++;
		tracker.add(row);
		tracker.add(col);
		arraySize+=2;
		return true;
		}
		
		
		return false;
		}
	// This method will undo the last moves made and change the next player.
	public void undo()
	{
		int row = 0;
		int col = 0;
		if(tracker.size()>0)
		{
		row = tracker.get(arraySize-2);
		col =tracker.get(arraySize-1);

		tracker.remove(arraySize-1);
		tracker.remove(arraySize-2);

		arraySize-=2;
		board[row][col] = " ";
		count--;
		}

	}

	/** This method returns the current contents of the game board.
	 * It will help you to understand how well to play haven seen
	 * which row or column u need to block from your opponent,
	 * and where to play to have a chance of winning.
	 */
	public String toString()
	{
	
		String result = "";
		int a= 0;
		boolean done = false;
		while(!done)
		{
			for(int b = 0;b <size; b++)
			{if((b+1) == size)
			{
				result+=" ";
				result+= board[a][b];
			
			}
			else
			{
				result+=" ";
				result += board[a][b];
			}
			if(b<size-1)
			{	
				result+=(" |");
			}
			}
			result+="\n";
			if(a == size-1)
				done = true;
			else
			{
				for(int j = 0; j < size-1; j++)
				{
					if(j ==(size-2))
					{
						result += "---+---";
					}
					else
						result+=("---+");
				}
				result+="\n";
				a++;
			}
		}
		return result;
	}


	/** This method checks the board and tell if it is full,
	 *
	 * @return true if full and false if not full.
	 */
	public boolean full()
	{
		for(int i = 0; i < board.length;i++)
		{
			for(int j = 0;j < board.length;j++ )

				if(board[i][j].equalsIgnoreCase(" "))
					return false;
		}

		return true;
	}
	
	
	
} 