import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String a = in.readLine();
		String b = in.readLine();

		if(b.equals("null")) {
			b = null;
		}
		
		String res1 = a.equals(b) ? "true" : "false";
		String res2 = a.equalsIgnoreCase(b) ? "true" : "false";
		
		if (a.equals("null")) {
			res1 = res2 = "NullPointerException";
		}

		System.out.print(res1 + "\n" + res2);
	}
}