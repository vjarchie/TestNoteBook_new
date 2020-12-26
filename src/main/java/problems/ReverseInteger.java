package problems;

public class ReverseInteger
{

	static int reverse(int x) {
		boolean negFlag = false;
		if(x<0){
			negFlag = true;
			x = -x;
		}

		int reverseNum = 0, prevNum = 0;

		while(x!=0){
			int digit = x%10;
			reverseNum = (reverseNum * 10) + digit;

			if((reverseNum-digit)/10 != prevNum)
				return 0;
			prevNum = reverseNum ;

			x=x/10;
		}

		return negFlag?-reverseNum:reverseNum;

	}

	public static void main(String args[]){
		int t = 1000000045;
		System.out.println(reverse(t));
	}

}
