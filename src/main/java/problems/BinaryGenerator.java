package problems;

/**
 * Generate all binary representations withing a range
 */

public class BinaryGenerator
{
	public static void main(String[] args) throws java.lang.Exception
	{
		for (int i = 0; i < 12; i++)
		{
			int n = i;
			int t = 1;
			int res = 0;
			while (n > 0)
			{
				int r = n % 2;
				n = n / 2;
				res = res + (t * r);
				t = t * 10;
			}
			System.out.println(String.format("%05d", res));
		}
	}
}
