package problems;

import java.util.ArrayList;
import java.util.List;

public class Romanizer
{
	public static List<String> romanizer(List<Integer> numbers) {
		List<String> results = new ArrayList<>();
		if(numbers.isEmpty()||numbers.size()<1){
			return results;
		}
		System.out.println("is :"+ numbers.size());
		int p=0;
		for(;p<numbers.size();p++){
			Integer number = numbers.get(p);
			System.out.println("processing : " + number);
			char c[] = new char[10001];
			int i=0;
			while(number != 0){
				if(number >=1000){
					i=digit('M', number/1000, i, c);
					number = number%1000;
				}
				else if(number >=500){
					if(number <900){
						i = digit('D', number/500, i, c);
						number = number%500;
					}else{
						i=subDigit('C', 'M',i,c);
					}
				}
				else if(number>=100){
					if(number<400){
						i=digit('C', number/100, i, c);
						number = number%100;
					}else{
						i=subDigit('C', 'D', i, c);
						number=number%100;
					}
				}
				else if(number>=50){
					if(number<90){
						i=digit('L', number/50, i, c);
						number=number%50;
					}else{
						i=subDigit('X', 'C', i, c);
						number=number%10;
					}
				}
				else if(number>=10){
					if(number<40){
						i=digit('X', number/10, i, c);
						number=number%10;
					}else{
						i=subDigit('X', 'L', i, c);
						number=number%10;
					}
				}
				else if(number>=5){
					if(number<9){
						i=digit('V', number/5, i, c);
						number=number%5;
					}else{
						i=subDigit('I', 'X', i, c);
						number=0;
					}
				}
				else if(number>=1){
					if(number<4){
						i=digit('I', number, i, c);
						number=0;
					}else{
						i=subDigit('I', 'V', i, c);
						number=0;
					}
				}
			}
			StringBuffer sb = new StringBuffer();
			for(int j=0;j<i;j++)
				sb.append(c[j]);

			results.add(sb.toString());
		}
		System.out.println("rs :"+ results.size());
		System.out.println(p);
		return results;

	}

	static int subDigit(char num1,char num2,int i,char[] c){
		c[i++] = num1;
		c[i++] = num2;
		return i;
	}
	static int digit(char ch, int n,int i,char[] c){
		for(int j=0;j<n;j++){
			c[i++] = ch;
		}
		return i;
	}

	public static void main(String args[]){
		List<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		List<String> result = romanizer(input);
		for(String string:result){
			System.out.println(string);
		}
	}
}
