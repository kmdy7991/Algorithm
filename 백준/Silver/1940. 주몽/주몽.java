import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());
		int m = stoi.apply(in.readLine());

		int[] iron = new int[n];
        
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			iron[i] = stoi.apply(st.nextToken());
		}

		findResult(iron, m);
	}

	private static void findResult(int[] iron, int m) {
		Arrays.sort(iron);
        
		int s = 0;
		int e = iron.length -1 ;
		int res = 0;
        
		while (s < e) {
			if (iron[s] + iron[e] < m) {
				s++;
			} else if (iron[s] + iron[e] > m) {
				e--;
			} else {
				res++;
				s++;
				e--;
			}
		}
        
		System.out.println(res);
	}
}
