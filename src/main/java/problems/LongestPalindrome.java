package problems;

public class LongestPalindrome
{
	static String longestPalindrome(String s)
	{
		if (s == null || s.length() <= 0)
			return "";

		int maxlen = 1;
		int start = 0;
		int len = s.length();

		int low, high;

		for (int i = 1; i < len; i++)
		{
			low = i - 1;
			high = i;
			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high))
			{
				if (high - low + 1 > maxlen)
				{
					start = low;
					maxlen = high - low + 1;
				}
				--low;
				++high;

			}

			low = i - 1;
			high = i + 1;

			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high))
			{
				if (high - low + 1 > maxlen)
				{
					start = low;
					maxlen = high - low + 1;
				}
				--low;
				++high;

			}

		}

		return s.substring(start, start + maxlen);

	}

	/**
	 * longest palindrome in given character sequence
	 *
	 * @param args
	 */
	public static void main(String args[])
	{
		String s = "abbd";

		System.out.println(longestPalindrome(s));
	}
}
