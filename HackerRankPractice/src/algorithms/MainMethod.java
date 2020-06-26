package algorithms;

import java.util.Arrays;

public class MainMethod {

	public static void main(String[] args) {
		/*Integer[] arr = {6,4,5,7,1,2,3};
		BubbleSort<Integer> bubblesort = new BubbleSort<>();
		bubblesort.sort(arr);
		System.out.println(Arrays.toString(arr));
		String[] name = {"Rubesh","Monisha","Aadhiya"};
		BubbleSort<String> bubblesort2 = new BubbleSort<>();
		bubblesort2.sort(name);
		System.out.println(Arrays.toString(name));
		Arrays.stream(name).forEach(n -> {
			System.out.println(n);
			System.out.println(n.hashCode());
			});*/
		
		int[] arr = {6,4,5,7,1,2,3};
		SelectionSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Index of value 4 is :: " + BinarySearch.search(arr, 4));
		System.out.println("Index of value 1 is :: " + BinarySearch.search(arr, 1));
		System.out.println("Index of value 7 is :: " + BinarySearch.search(arr, 7));
	}

}
