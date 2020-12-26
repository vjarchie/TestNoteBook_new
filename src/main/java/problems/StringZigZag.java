package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringZigZag
{
	static String convert(String s, int numRows) {
		if(numRows == 0)
			return "";
		if(numRows==1)
			return s;

		Map<Integer,StringBuffer> test = new HashMap<>();
		String[] arr = new String[numRows];
		Arrays.fill(arr,"");
		int row = 0;
		boolean down = true;


		for(int i=0;i<s.length();i++){
			arr[row] += s.charAt(i);
			if(row == numRows-1)
				down = false;
			else if(row == 0)
				down = true;
			if(down)
				row++;
			else
				row --;

		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}

		return sb.toString();
	}

	public static void main(String args[]){
		String sample = "PAYPALISHIRING";
		System.out.println(convert(sample,3));
		System.out.println(convert(sample,4));
	}
}
