import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {
	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {
		char[] stringarr = s.toCharArray();
	
		int totalDeletion = 0;
		for (int i = 0; i < stringarr.length; i++) {
			if (i == stringarr.length-1) {
				break;
			}
			char previous = stringarr[i];
			char next = stringarr[i + 1];
			if(previous == next)
			{
				totalDeletion++;
			}
			
		}
		return totalDeletion;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = alternatingCharacters(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();*/
		System.out.println(alternatingCharacters("Roobesh"));
	}
}
