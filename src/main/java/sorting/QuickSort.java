package sorting;

public class QuickSort
{
	void sort(int[] inputArr,int low,int high){

		if(low<high){
			int p = partition(inputArr,low,high);
			sort(inputArr,low,p-1);
			sort(inputArr,p+1,high);
		}
	}

	int partition ( int[] arr,int low, int high){
		int t = arr[high];
		int i= low-1;

		for(int j=low;j<high;j++){
			if(arr[j]<t){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i+1];
		arr[i+1]=arr[high];
		arr[high] = temp;

		return i+1;

	}

	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6, 7, 1, 3, 4, 6, 7 };

		System.out.println("Given Array for Quick Sort");
		printArray(arr);

		QuickSort ob = new QuickSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);

	}



}
