import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi.apply(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int max = -(int) 1e9;
		int min = (int) 1e9;
		for(int i = 0; i < n; i++) {
			int num = stoi.apply(st.nextToken());
			
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		
		System.out.println(min + " " + max);
	}
}