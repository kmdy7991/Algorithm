import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int num = stoi.apply(st.nextToken());
		int type = stoi.apply(st.nextToken());
		
		System.out.println(Integer.toString(num, type).toUpperCase());
	}
}