package problems;

class NTUCPartition
{
	public int solution(int[] A, int K, int L)
	{
		if ((K + L) > A.length)
			return -1;
		int n = A.length;
		int[] zarr = new int[n];
		zarr[0] = A[0];
		for (int i = 1; i < n; i++)
		{
			zarr[i] = zarr[i - 1] + A[i];
		}
		int max = -1;
		for (int i = 0; i < n; i++)
		{
			int ks = 0, ls = 0;
			int j = i + K - 1;
			if (j < n)
			{
				if (i - 1 >= 0)
				{
					ks = zarr[j] - zarr[i - 1];
				}
				else
				{
					ks = zarr[j];
				}
				ls = secSol(zarr, i, j, L);
				int ts = ks + ls;
				if (max < ts)
				{
					max = ts;
				}
			}

		}

		return max;

	}

	public int secSol(int[] zarr, int p, int q, int l)
	{
		int sol = 0;
		int max = -1;
		int n = zarr.length;
		for (int i = 0; i < n; i++)
		{
			int j = i + l - 1;
			if (j < n && ((i < p && j < p) || (i > q && j > q)))
			{
				if (i - 1 >= 0)
				{
					sol = zarr[j] - zarr[i - 1];
				}
				else
				{
					sol = zarr[j];
				}
				if (sol > max)
				{
					max = sol;
				}
			}
		}
		return max;
	}

}
