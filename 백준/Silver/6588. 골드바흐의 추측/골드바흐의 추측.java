import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		boolean[] prime = init();

		int n = -1;

		while ((n = stoi.apply(in.readLine())) != 0) {
			int leftRes = -1;
			int rightRes = -1;

			int max = 0;
            
			boolean flag = false;
			for(int i = 3; i < n + 1; i++) {
				
                if(!prime[i] &&  !prime[n - i]) {
					leftRes = i;
					rightRes = n - i;
					flag = true;
					break;
				}
			}

			if (!flag) {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			} else {
				sb.append(n).append(" = ").append(leftRes).append(" + ").append(rightRes).append("\n");
			}
		}

		System.out.print(sb);
	}

	private static boolean[] init() {
		boolean[] prime = new boolean[(int) 1e6 + 1];

		for (int i = 2; i < Math.sqrt((int) 1e6 + 1) + 1; i++) {
			for (int j = i + i; j < (int) 1e6 + 1; j += i) {
                if (prime[j]) {
					continue;
				}
                
				prime[j] = true;
			}
		}

		return prime;
	}
}
