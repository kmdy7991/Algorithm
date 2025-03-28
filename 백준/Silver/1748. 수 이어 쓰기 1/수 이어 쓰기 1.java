import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String n = in.readLine();
		
		int len = n.length() - 1;
		
		long res = 0;
		for(int i = 0; i < len; i++) {
			
			res += 9 * Math.pow(10, i) * (i + 1);
		}
		
		System.out.print(res + (int) (Integer.parseInt(n) - Math.pow(10, len) + 1) * (len + 1));
	}
}
