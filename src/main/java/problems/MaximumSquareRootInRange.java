package problems;

public class MaximumSquareRootInRange
{
	public static int maximumPerfectSquareInRange(int A, int B)
	{
		// write your code in Java SE 8
		int result = 0;
		while (A <= B)
		{
			int m = (int) Math.ceil(Math.sqrt(A));
			int n = (int) Math.ceil(Math.sqrt(B));
			if (m == A && n == B)
				break;
			A = m;
			B = n;
			if (A <= B)
			{
				result++;
			}
		}
		return result;
	}

	/**
	 * maximum times a number in range can be squared recursively
	 *
	 * @param args
	 */
	public static void main(String args[])
	{
		System.out.println(maximumPerfectSquareInRange(1,20));
	}
}
