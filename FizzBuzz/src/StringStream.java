import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class StringStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "GeeksforGeeks";
		char[] dataChar = data.toCharArray();
		Map<Character, Integer> value = new HashMap();
		for (char c : dataChar) {
			value.merge(c, 1, new BiFunction<Integer, Integer, Integer>() {

				@Override
				public Integer apply(Integer arg0, Integer arg1) {
					// TODO Auto-generated method stub
					return arg0 + arg1;
				}

			});
		}
		System.out.println(value);
	}

}
