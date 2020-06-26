package algorithms;

import java.util.Arrays;

public class BubbleSort<T> {

	public static <T> void sort(T[] arr)
	{
		int size = arr.length;
		for(int i=0;i<size-1;i++)
		{
			for(int j=0;j<size-1-i;j++) {
			if(arr[j].hashCode() > arr[j+1].hashCode())
			{
				T temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp; 						
			}
			
		  }
			System.out.println(Arrays.toString(arr));
			System.out.println("==========================");
		}
	}
}
