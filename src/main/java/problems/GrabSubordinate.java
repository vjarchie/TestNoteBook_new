package problems;

import java.util.HashMap;
import java.util.Map;

public class GrabSubordinate
{

	public static int peopleSubordinate(int[] ranks)
	{
		// write your code in Java SE 8
		int result = 0;
		if (ranks.length <= 1)
		{
			return result;
		}
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i = 0; i < ranks.length; i++)
		{
			int key = ranks[i];
			if (countMap.containsKey(ranks[i]))
			{
				countMap.put(key, countMap.get(key) + 1);
			}
			else
			{
				countMap.put(key, 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet())
		{
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}

		for (Map.Entry<Integer, Integer> rank : countMap.entrySet())
		{
			int key = rank.getKey();
			if (countMap.containsKey(key + 1))
			{
				result += countMap.get(key);
			}

		}
		return result;

	}

	// all people subordinate to next i+1 ranking
	public static void main(String args[])
	{
		int[] input = new int[] { 1, 2, 2, 3, 3, 4 };
		System.out.println("no. of people reporting=" + peopleSubordinate(input));
	}

}
