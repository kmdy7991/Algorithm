import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String[] call = { "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

		int res = 0;
		for (char c : in.readLine().toCharArray()) {
			for (int i = 0; i < call.length; i++) {
				if (call[i].contains(Character.toString(c))) {
					res += (i + 3);
				}
			}
		}
		
		System.out.print(res);
	}
}