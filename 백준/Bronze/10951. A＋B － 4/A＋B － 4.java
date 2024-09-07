import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String line;
		while ((line = in.readLine()) != null) {
			String[] num = line.split(" ");
			System.out.println(stoi.apply(num[0]) + stoi.apply(num[1]));
		}
	}
}