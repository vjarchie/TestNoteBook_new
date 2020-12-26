package problems;

public class ArrayDiff
{
	static int findDifference(Integer a,Integer b){
		int result = 0;
		while(a>9 && b >9){
			int tempA=a%10;
			//System.out.println("ta = "+ tempA);
			int tempB=b%10;
			//System.out.println("tb = "+ tempB);
			result += Math.abs(tempA-tempB);
			a/=10;
			b/=10;
			//System.out.println("a="+a+" b="+b);

		}
		result += Math.abs(a-b);

		return result;
	}

	public static void main(String args[]){
		System.out.println(findDifference(100,200));
	}
}
