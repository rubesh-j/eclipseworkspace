import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.sql.RowSet;


public class ApplesAndOranges {
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		List<Integer> appleFall  = sumArr(apples,a);
		List<Integer> orangeFall  = sumArr(oranges,b);
		Predicate filterFruit = new Predicate<Integer>() {
			public boolean test(Integer fallLocation) {
				if(fallLocation >= s && fallLocation <=t)
				{
				return true;
				}
				return false;
			}	
		};
		long appleCount = appleFall.stream().filter(filterFruit).count();
		long orangeCount = orangeFall.stream().filter(filterFruit).count();
		System.out.println(appleCount);
		System.out.println(orangeCount);
    }

    static List<Integer> sumArr(int[] arr, int sumValue)
    {
    	IntFunction<Integer> func = new IntFunction<Integer>(){

			@Override
			public Integer apply(int arg0) {
				// TODO Auto-generated method stub
				return arg0+sumValue;
			}			
    		
    	};
    	return Arrays.stream(arr).mapToObj(func).collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
		System.out.println(sumArr(new int[] {1,5,6,7},4));
	}

}
