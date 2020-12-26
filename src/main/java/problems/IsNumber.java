package problems;

public class IsNumber
{
	/*
	check if valid number
	 */
	public static void main(String args[])
	{
		String test = ".1";
		System.out.println(isNumber(test));
	}

	public static boolean isNumber(String s)
	{

		if (s == null || s == "")
			return false;
		boolean e = false, d = false, sig = false, dig = false, dige = false, dac = false;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == ' ')
				continue;
			if (s.charAt(i) == '-' || s.charAt(i) == '+')
			{
				if (sig == false)
					sig = true;
				else
					return false;
				continue;

			}
			if (s.charAt(i) == 'e')
			{
				if (e == false && dig == true)
					e = true;
				else
					return false;
				continue;
			}
			if (s.charAt(i) == '.')
			{
				if (d == false && e == false)
					d = true;
				else
					return false;
				continue;
			}
			if (s.charAt(i) < '0' || s.charAt(i) > '9')
			{
				return false;
			}

			if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
			{
				if (dig == false)
					dig = true;
				if (dige == false)
				{
					if (e == true)
					{
						dige = true;
					}
				}
				if (dac == false)
				{
					if (d == true)
						dac = true;
				}
			}

		}
		if ((e == true && dige == false) || dig == false)
			return false;
		return true;
	}
}
