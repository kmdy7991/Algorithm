import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line = in.readLine();

		System.out.println(palindrome(line));
	}

	private static int palindrome(String line) {
		int s = 0;
		int e = line.length() - 1;
		
		while (s < e) {
			if(line.charAt(s++) != line.charAt(e--)) {
				return 0;
			}
		}
		return 1;
	}
}