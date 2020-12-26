package sorting;

public class MergeSort
{

	//static int times = 0;

	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		//merge sort

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);

		//quick sort
		System.out.println("Given Array");
		printArray(arr);

	}

	void sort(int[] arr, int low, int high)
	{
		//times ++;
		//System.out.println("iter: "+ times);
		if (low < high)
		{
			int mid = (high + low) / 2;
			//	System.out.println(mid);

			sort(arr, low, mid);
			sort(arr, mid + 1, high);

			mergeUtil(arr, low, mid, high);
		}

		//printArray(arr);

	}

	void mergeUtil(int[] arr, int low, int mid, int high)
	{

		int n1 = mid - low + 1;
		int n2 = high - mid;

		int[] left = new int[n1];
		int[] right = new int[n2];

		for (int i = 0; i < n1; i++)
			left[i] = arr[low + i];

		for (int i = 0; i < n2; i++)
			right[i] = arr[mid + 1 + i];

		int i = 0, j = 0;

		int k = low;

		while (i < n1 && j < n2)
		{
			if (left[i] <= right[j])
			{
				arr[k] = left[i];
				i++;
			}
			else
			{
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < n1)
		{
			arr[k] = left[i];
			i++;
			k++;
		}

		while (j < n2)
		{
			arr[k] = right[j];
			k++;
			j++;
		}

	}

}
