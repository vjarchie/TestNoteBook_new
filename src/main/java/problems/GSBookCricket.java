package problems;

import java.util.Arrays;

public class GSBookCricket
{
	// ways to reach score with only 2,4,6
	static int noOfWaysToDrawTheGame(int totalScore) {
		if(totalScore<0){
			return 0;
		}
		int table[] = new int[totalScore+1];
		Arrays.fill(table,0);
		table[0] = 1;
		for(int i=2;i<=totalScore;i++){
			table[i] = table[i-2];
		}
		for(int i=4;i<=totalScore;i++){
			table[i] = table[i-4]+ table[i-2];
		}
		for(int i=6;i<=totalScore;i++){
			table[i] = table[i-6]+table[i-4]+ table[i-2];
		}

		return table[totalScore];



	}

	public static void main(String args[]){
		System.out.println(noOfWaysToDrawTheGame(6));
	}

}
