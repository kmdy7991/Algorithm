import java.io.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int t = stoi.apply(in.readLine());
		boolean[] primes = init();

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = stoi.apply(in.readLine());

			sb.append(primeSum(n, primes)).append("\n");
		}
        
		System.out.print(sb);
	}

	private static String primeSum(int num, boolean[] primes) {
		for (int i = 2; i < 1001; i++) {
			if (primes[i]) {
				continue;
			}
            
			for (int j = 2; j < 1001; j++) {
				if (primes[j]) {
					continue;
				}
                
				for (int k = 2; k < 1001; k++) {
					if (!primes[k] && i + j + k == num) {
						return i + " " + j + " " + k;
					}
				}
			}
		}

		return "0";
	}

	private static boolean[] init() {
		boolean[] arr = new boolean[1001];

		for (int i = 2; i <= Math.sqrt(1001); i++) {
			for (int j = i + i; j < 1001; j += i) {
				arr[j] = true;
			}
		}

		return arr;
	}
}