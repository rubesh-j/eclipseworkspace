import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Substring {
	static String twoStrings(String s1, String s2) {
      	char[] data1 = s1.toCharArray();
      	char[] data2 = s2.toCharArray();
      	
      	Set<Character> dataSet1 = new HashSet<Character>();
      	Set<Character> dataSet2 = new HashSet<Character>();
      	
      	for(char d : data1)
      	{
      		dataSet1.add(d);
      	}
      	for(char d : data2)
      	{
      		dataSet2.add(d);
      	}
      	dataSet1.retainAll(dataSet2);
      	
      	return ((dataSet1.isEmpty()) ? "No" : "Yes");
      	
    }
}
