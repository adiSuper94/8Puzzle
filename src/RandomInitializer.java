import java.util.Random;

public class RandomInitializer {
	
	int i,j,temp;
	boolean isPresent;
	/**
	 * Constructor which randomly assigns number in the range [0,9] to the matrix is EightPuzzleLogic.
	 * Position of 0 is predefined as (3,3).
	 * @param bj
	 * @param bi
	 * @param m
	 */
	public RandomInitializer(int bj,int bi,int m[][])
	{
		Random r = new Random();
	
		for(i=1;i<=3;i++)
		{
			Y:	for(j=1;j<=3;j++)
			{
				if((i==bi)&&(j==bj))
					continue Y;

				for(;m[i][j]==0;)
				{
					temp=r.nextInt(9);
					this.matrixSearch(temp,m);
					if(false==isPresent)
						m[i][j]=temp;
				}

			}
		}

	}
	
	/**
	 * Method which searches the matrix m and if the element number is present in it or not .
	 * @param number
	 * @param m
	 */
	public void matrixSearch(int number,int m[][])
	{
		int i,j;
		isPresent=false;
		for(i=1;i<=3;i++)
			for(j=1;j<=3;j++)
				if(m[i][j]==number)
					isPresent=true;


	}
}