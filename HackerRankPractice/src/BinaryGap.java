
public class BinaryGap {
	public static void main(String[] args) {
		System.out.println(solution(74901729));
	}

public static int solution(int N) {
    // write your code in Java SE 8
    
    Integer in = new Integer(N);
    String binaryValue = in.toBinaryString(in);
    char[] each = binaryValue.toCharArray();
    System.out.println(binaryValue);
    int count = 0;
    int tempVale = 0;
    for(int i = 0; i < each.length; i++)
    {
    	System.out.println("Count : " + count);
    	System.out.println("Character : " + each[i]);
    	
        if(each[i] == '0')
        {
            tempVale++;
        }
        else
        {
            if(tempVale > count)
            {
            	System.out.println(tempVale);
                count = tempVale;
               
            }
            tempVale = 0;
        }
        System.out.println("Current coount : " + tempVale);
        System.out.println("__________________________");
        
    }
    return count;
   
}
}
