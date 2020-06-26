import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
        Function<Integer,Integer> funct = new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer t) {
				if(t < 38) {
					return t;
				}
				else if ((t%5) > 2){
					return t+(5-(t%5));
				}
				else {
				return t;
				}
			}

		  	
        };
        return grades.stream().map(funct).collect(Collectors.toList());
    }

}