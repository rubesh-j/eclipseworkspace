import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ArraySum {
	 static int simpleArraySum(int[] ar) {
	        /*
	         * Write your code here.
	         */
		 	int sum=0;
		 	sum = Arrays.stream(ar).sum();
		 
		 	
		 	return sum;
	            
	    }
	 
	 static List<Integer> value (List<Integer> a, List<Integer> b){
		 List<Integer> value = new ArrayList<Integer>();
         value.add(0);
         value.add(0);
         int count = 0;
		while( count > 3)
         {
         if(a.get(count) > b.get(count))
         {
             value.set(1, value.get(1)+1 );
         }
         else if(a.get(count) < b.get(count))
         {
             value.set(2, value.get(2)+1 );
         }
         else{

         }
         }
     return value;
	 }
	 
	 public static void main(String[] args) throws ParseException{
		 String sDate1="07:05:45PM";
		 //Date d = new Date();
		 SimpleDateFormat df = new SimpleDateFormat("hh:mm:ssaa");
		 System.out.println(df.parse(sDate1));
		 SimpleDateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
		 System.out.println(outputformat.format(df.parse(sDate1)));
		 System.out.println(df.format(df.parse(sDate1)));
	 }
}
