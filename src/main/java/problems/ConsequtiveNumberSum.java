package problems;

public class ConsequtiveNumberSum
{
	public static int consecutive(long num)
	{
		while ((num & 1) == 0)
			num >>= 1;
		int result = 1, i = 3;

		while (i * i <= num)
		{
			int j = 0;
			while (num % i == 0)
			{
				num /= i;
				j++;
			}
			result *= j + 1;
			i += 2;
		}

		if (num > 1)
			result <<= 1;
		return result;
	}

	/**
	 * number of ways number can be represented as sum of consequitve positive numbers
	 *
	 * @param args
	 */
	public static void main(String args[])
	{
		System.out.println(consecutive(5));
	}
}
