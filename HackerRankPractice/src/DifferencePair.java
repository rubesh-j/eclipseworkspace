import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DifferencePair {
	static int pairs(int k, int[] arr) {
		Arrays.sort(arr);
		List<Integer> data = new ArrayList<Integer>();
		data = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		System.out.println(data.subList(3,data.size()));
		System.out.println(data);
		
		System.out.print(arr);
		int diff = 0;
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i] - k;
			System.out.print(val);
			System.out.print(" ");
			System.out.print(Arrays.binarySearch(arr, val));
			System.out.println();
			
			if(Arrays.binarySearch(arr, val) >= 0)
			{
				diff++;
			}
			
		}
		return diff;
	}

	public static void main(String[] args) {
		System.out.println(pairs(1, new int[] { 363374326 ,61825162 ,61825163, 1073065718, 1281246024, 1399469912 ,428047635, 491595254, 879792181, 1069262793 }));
		//System.out.println(Arrays.binarySearch(new int[] { 5, 6, 7, 8 }));
	}
}
