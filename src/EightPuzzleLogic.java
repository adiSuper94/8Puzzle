
public class EightPuzzleLogic
{

	/**
	 * Declares necessary variables and integer matrix m.
	 */
	int i,j,bi,bj,n,x,y;
	Boolean isGameWon=true;
	int m[][];
	
	/**
	 * Constructor which initializes the process of creating a start state. 
	 */
	public EightPuzzleLogic()

	{
		bi=3;
		bj=3;
		m = new int[5][5];


		for(i=0;i<5;i++)
		{
			m[4][i]=99;
			m[i][4]=99;
			m[0][i]=99;
			m[i][0]=99;
		}

		for(i=1;i<=3;i++)
			for(j=1;j<=3;j++)
				m[i][j] = 0;
		



		@SuppressWarnings("unused")
		RandomInitializer i = new RandomInitializer(bi,bj,m);
	}

	/**
	 * Defines the goal state
	 * and checks if the goal state is reached or not.
	 * @return boolean
	 */
	public boolean winCheck()
	{
		isGameWon = true;
		n=1;
		Z:	for(int i=1;i<=3;i++)
			for(int j=1;j<=3;j++)
			{
				if((m[i][j]==n)&&isGameWon==true)
					n++;
				else if((i==3)&&(j==3)&&(isGameWon==true))
				{

				}
				else
				{
					isGameWon=false;
					break Z;
				}

			}
		return isGameWon;
	}

	/**
	 * swaps the blank tile with the tile specified by the parameters x and y,if possible.
	 * @param x
	 * @param y
	 * @return
	 */
	public EightPuzzleLogic move(int x,int y)

	{
		if((m[x+1][y]==0)||(m[x-1][y]==0)||(m[x][y+1]==0)||(m[x][y-1]==0))
		{
			m[bi][bj] = m[x][y];
			m[x][y] = 0;
			bi=x;
			bj=y;


			isGameWon = winCheck();
			

		}
		return this;

	}

}