package problems;

public class GSAlphanumericSequenceFromNumberString
{
	public static long calculatePossibleCombinations(String inputStr)
	{
		if (inputStr == null || inputStr.length() == 0 || inputStr.charAt(0) == '0')
			return 0;
		int n = inputStr.length();
		int count[] = new int[n + 1];
		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i <= n; i++)
		{
			count[i] = 0;
			if (inputStr.charAt(i - 1) > '0')
			{
				count[i] = count[i - 1];
			}
			if (inputStr.charAt(i - 2) == '1' || (inputStr.charAt(i - 2) == '2' && inputStr.charAt(i - 1) < '7'))
			{
				count[i] += count[i - 2];
			}
		}

		return count[n];
	}

	/*
	ways to represent number string as alphanumeric when character is mapped as a->1 b->2.. z->26
	 */
	public static void main(String args[])
	{
		String num = "11111";
		System.out.println(calculatePossibleCombinations(num));
	}
}
