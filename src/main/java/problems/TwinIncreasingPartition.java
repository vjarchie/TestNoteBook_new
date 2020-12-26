package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// TODO


/**
 * input form
 * 1
 * 10
 * 1 2 8 4 3 11 12 13 14 15
 */
public class TwinIncreasingPartition
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++)
		{
			int N = Integer.parseInt(br.readLine().trim());
			String[] arr_Arr = br.readLine().split(" ");
			int[] Arr = new int[N];
			for (int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
			{
				Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
			}

			int out_ = SubAndSuperArray(Arr, N);
			int out2_ = lisWithBreak(Arr,N);
			wr.println(out_);
			wr.println(out2_);
		}

		wr.close();
		br.close();
	}

	static int SubAndSuperArray(int[] Arr, int N)
	{
		int[] maxArr = new int[N];
		maxArr[0] = 1;
		for (int i = 1; i < N; i++)
		{
			if (Arr[i] > Arr[i - 1])
			{
				maxArr[i] = maxArr[i - 1] + 1;
			}
			else
			{
				maxArr[i] = 1;
			}

		}
		int max = 0;
		for (int i = 0; i < N; i++)
		{
			int tmax = maxArr[i] + subArrayUtil(Arr, i + 1, Arr[i]);
			if (tmax > max)
			{
				max = tmax;
			}
		}

		return max;

	}

	static int subArrayUtil(int[] Arr, int x, int p)
	{
		int max = 0;
		int n = Arr.length;
		if (x < n)
		{
			for (int i = x; i < n; i++)
			{
				int clen = 0;
				int temp = p;
				while (i < n && Arr[i] > temp)
				{
					temp = Arr[i];
					clen += 1;
					i = i + 1;

				}
				if (clen > max)
				{
					max = clen;
				}
			}
		}
		return max;
	}

	static int lisWithBreak(int arr[],int n){
		int max=0;
		int[] lis = new int[n];

		lis[0] = 1;
		int meh = 1;
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && lis[i]<lis[j]+1){
					lis[i]=lis[j]+1;
					if(meh<lis[i]){
						meh=lis[i];
					}
				}
			}
			if(meh>max){
				max=meh;
			}
		}

		return max;
	}
}