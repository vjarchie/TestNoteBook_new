package problems;

public class StringToInteger
{
	public static void main(String args[]){
		String test = "     ";
		System.out.println(myAtoi(test));
	}

	public static int myAtoi(String str) {
		if(str==null || str == "")
			return 0;
		int base=0,sign=1,i=0;
		while(i < str.length() && str.charAt(i)==' '){
			i++;
		}

		if(i < str.length() && (str.charAt(i)== '-'||str.charAt(i)== '+')){
			if(str.charAt(i)== '-')
				sign= -1;
			i++;
		}

		while(i < str.length() && str.charAt(i) >='0' && str.charAt(i)<='9'){
			if(base > Integer.MAX_VALUE/10 ||(base == Integer.MAX_VALUE/10 && str.charAt(i)-'0' > 7) ){
				if(sign==1){
					return Integer.MAX_VALUE;
				}
				else
					return Integer.MIN_VALUE;
			}
			base = 10*base + str.charAt(i++)-'0';

		}
		return base*sign;




	}
}
