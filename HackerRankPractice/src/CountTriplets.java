import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountTriplets {

	static void countTriplets(List<Long> arr, long r) {
		Collections.sort(arr);
		List<Long> multiplyList = new ArrayList<Long>();
		//multiplyList.set(1, element)
		Long tempVal = 1L;
		while(tempVal<= arr.get(arr.size() -1)) {
			multiplyList.add(tempVal);
			tempVal = tempVal*r;			
			System.out.println(tempVal);
		}
			System.out.println(multiplyList);
			Long.valueOf(multiplyList.size());
	}
	
	public static void main(String[] args) {
		List<Long> data = new ArrayList<Long>(Arrays.asList(1L,5L,5L,20L,25L,125L));
		System.out.println(data.size());
		System.out.println(data.get(0));
	}
}

	
