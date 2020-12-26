package problems;

public class MaxChainLength
{
	int a;
	int b;

	public MaxChainLength(int a, int b)
	{
		this.a = a;
		this.b = b;

	}

	/**
	 * longest chain formed from pairs in ascending order
	 *
	 * @param args
	 */
	public static void main(String args[])
	{
		//array already sorted
		MaxChainLength arr[] = new MaxChainLength[] { new MaxChainLength(5, 24), new MaxChainLength(15, 25),
				new MaxChainLength(27, 40), new MaxChainLength(50, 60) };
		System.out.println(maxChainLengthCalc(arr, 4));
	}

	static int maxChainLengthCalc(MaxChainLength arr[], int n)
	{
		int i, j, max = 0;
		int mcl[] = new int[n];

		for (i = 0; i < n; i++)
		{
			mcl[i] = 1;
		}

		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
			{
				if (arr[i].a > arr[j].b && mcl[i] < mcl[j] + 1)
					mcl[i] = mcl[j] + 1;

			}
		for (i = 0; i < n; i++)
			if (max < mcl[i])
				max = mcl[i];

		return max;
	}

}
