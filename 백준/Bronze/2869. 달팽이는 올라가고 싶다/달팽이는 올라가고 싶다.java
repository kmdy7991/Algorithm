import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int a = stoi.apply(st.nextToken());
		int b = stoi.apply(st.nextToken());
		int v = stoi.apply(st.nextToken());
		
		int res = (v - a) % (a - b) == 0 ? 1 : 2;

		System.out.println(((v - a) / (a - b)) + res);
	}
}