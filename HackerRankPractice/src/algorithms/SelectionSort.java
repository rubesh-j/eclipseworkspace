package algorithms;

import java.util.Arrays;

public class SelectionSort {
	
	public static void sort(int[] arr)
	{
		int size = arr.length;
		for(int i = 0 ; i < size-1;i++)
		{
			int minimumIndex = i;
			for(int j = i; j < size-1;j++)
			{
				if(arr[j] > arr[j+1])
				{
					minimumIndex = j+1;
				}
			}
			System.out.println("==================================");
			System.out.println(Arrays.toString(arr));
			System.out.println(minimumIndex);
			int temp = arr[i];
			arr[i] = arr[minimumIndex];
			arr[minimumIndex] = temp;
			System.out.println(Arrays.toString(arr));
			System.out.println("==================================");
		}
	}

}
