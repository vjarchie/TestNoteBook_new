package problems;

public class PalindromeNumber
{
	public static void main(String args[]){
		int test=1000021;
		System.out.println(isPalindrome(test));
		System.out.println(isrevPalindrome(test));
	}


	public static boolean isPalindrome(int x) {
		if(x<0)
			return false;
		int divisor=1;
		while(x/divisor>=10){
			divisor=divisor*10;
		}


		int p=1;
		while(x!=0)
		{
			System.out.println("divisor="+divisor);
			System.out.println("number after iteration "+p+"="+x);
			int l = x % 10;
			int h = x / divisor;
			System.out.println("l="+l+" h="+h);
			if(l!=h)
				return false;

			x = (x % divisor) / 10;
			divisor = divisor/100;
			p=p+1;

		}

		return true;


	}

	public static boolean isrevPalindrome(int x) {
		if(x<0 || (x%10 == 0 && x !=0))
			return false;
		int revno=0;

		while(x>revno){
			revno = revno*10 + x%10;
			x=x/10;
		}

		if(x==revno || x==revno/10)
			return true;

			return false;



	}
}
