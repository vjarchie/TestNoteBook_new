package problems;

public class DistinctSubstringFromEnds
{
	public static long substringCalculator(String s)
	{
		// Write your code here
		TrieNode root = new TrieNode();
		//Set<String> substrings = new HashSet<>();
		int count = 0;

		for (int i = 0; i < s.length(); i++)
		{
			String sub = s.substring(i);

			for (int j = 0; j < sub.length(); j++)
			{
				String subDistinct = sub.substring(0, sub.length() - j);

				//				if(!substrings.contains(subDistinct))
				//				{
				//					substrings.add(subDistinct);
				//					//System.out.println(subDistinct);
				//					count += 1;
				//				}
				//				else
				//				{
				//					continue;
				//				}
				if (!search(root, subDistinct))
				{
					insert(root, subDistinct);
					//	System.out.println(subDistinct);
					count++;
				}
				else
				{
					continue;
				}
			}
		}
		//	System.out.println(count);

		return count;

	}

	static void insert(TrieNode root, String key)
	{
		int level;
		int length = key.length();
		int index;

		TrieNode temp = root;

		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
			if (temp.children[index] == null)
				temp.children[index] = new TrieNode();

			temp = temp.children[index];
		}

		temp.isEndOfWord = true;
	}

	static boolean search(TrieNode root, String key)
	{
		int level;
		int length = key.length();
		int index;
		TrieNode temp = root;

		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';

			if (temp.children[index] == null)
				return false;

			temp = temp.children[index];
		}

		return (temp != null && temp.isEndOfWord);
	}

	/*
	number of distinct substrings when characters can be removed only from ends
	 */

	public static void main(String args[])
	{
		long s = substringCalculator("kincenvizh");
		System.out.println(s);
	}

	static class TrieNode
	{
		TrieNode[] children = new TrieNode[26];

		boolean isEndOfWord;

		TrieNode()
		{
			isEndOfWord = false;
			for (int i = 0; i < 26; i++)
				children[i] = null;
		}
	}
}
