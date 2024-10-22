import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean[] prime = init();
		
		int n = stoi.apply(in.readLine());
		
		int cnt = 0;
        
		st = new StringTokenizer(in.readLine());
		while(st.hasMoreTokens()) {
			if(!prime[stoi.apply(st.nextToken())]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static boolean[] init() {
		boolean[] prime = new boolean[1001];

		for (int i = 2; i <= Math.sqrt(1001) + 1; i++) {
			for (int j = i * 2; j <= 1000; j += i) {
				prime[j] = true;
			}
		}

		prime[0] = prime[1] = true;
		
		return prime;
	}
}