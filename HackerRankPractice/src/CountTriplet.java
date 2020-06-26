import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CountTriplet {
	// Complete the countTriplets function below.
	static void minimumBribes(int[] q) {
		int[] a = q.clone();
		int bribes = 0;
		for (int i = a.length-1; i>0; --i) 
		{
		if (a[i-1] == i+1) {
		a[i-1] = a[i];
		bribes++;
		} else if (i>=2 && a[i-2] == i+1) {
		a[i-2] = a[i-1];
		a[i-1] = a[i];
		bribes+=2;
		} else if (a[i] != i+1) {
		System.out.println("Too chaotic");
		return;
		}
		}
		System.out.println(bribes);
		
		/*boolean tooChaotic = false;
		int count = 0;
		int intialValue =1;
			for(int i = 0; i < q.length-1; i++)
			{
				System.out.println(intialValue);
				//System.out.println(intialValue);
				if(q[i] != intialValue)
				{
					int tempval = q[i] - intialValue;
					System.out.println(q[i] + " has moved " + tempval + " places to " + intialValue + " position" );
				//	System.out.println(tempval);
					if(tempval > 2)
					{
						tooChaotic = true;
					}
					else {
						
					}
				}
				intialValue++;
			}
			if(tooChaotic)
			{
				System.out.println("Too chaotic");
			}
			else {
				System.out.println(count);
			}*/
    }

	public static void main(String[] args) {
		minimumBribes(new int[] { 1,2,5,3,7,8,6,4 });
		int val = 5-3+7+8-6-4;
		System.out.println(val);
	}
}
