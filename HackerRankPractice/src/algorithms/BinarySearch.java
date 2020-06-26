package algorithms;

import java.util.Random;

public class BinarySearch {

	public static int search(int[] arr,int searchValue)
	{
		int value = 0;
		boolean found = false;
		int middle = (arr.length-1)/2;
		System.out.println(middle);
		if(arr[middle] > searchValue)
		{
			System.out.println("Inside first if");
			for(int i = 0; i < middle; i++)
			{
				if(arr[i] == searchValue)
				{
					found = true;
					return i;
				}
			}
		}
		else if(arr[middle] < searchValue)
		{
			System.out.println("Inside else if :: " + arr[middle]);
			for(int i = middle; i < arr.length ; i++)
			{
				if(arr[i] == searchValue)
				{
					found = true;
					return i;
				}
			}
		}
		else {
			System.out.println("Inside else");
			return middle;
		}
		return -1;
	}
}
