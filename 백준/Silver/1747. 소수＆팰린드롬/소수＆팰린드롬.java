import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		prime = new boolean[(int) 2e6 + 1];

		init();

		for (int i = n; i <= (int) 2e6 + 1; i++) {
			if (!prime[i]) {
                
				if(match(String.valueOf(i))) {
					System.out.println(i);
					break;
				}
				
			}
		}
	}

	private static boolean match(String num) {
		int s = 0;
		int e = num.length() - 1;
		while(s < e) {
			if(num.charAt(s++) != num.charAt(e--)) {
				return false;
			}
		}
		
		return true;
	}

	private static void init() {
		prime[1] = true;
		for (int i = 2; i <= Math.sqrt((int) 2e6 + 1); i++) {
			for (int j = i << 1; j < (int) 2e6 + 1; j += i) {
				prime[j] = true;
			}
		}
	}
}