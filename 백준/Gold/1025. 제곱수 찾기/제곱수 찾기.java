import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
        
		findMaxValue(n, m, arr);
	}

	private static void findMaxValue(int n, int m, int[][] arr) {
		int res = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int a = -n; a < n; a++) {
					for (int b = -m; b < m; b++) {
						if (a == 0 && b == 0) {
							continue;
						}

						int x = i;
						int y = j;
						int sum = 0;

						while (x >= 0 && x < n && y >= 0 && y < m) {
							sum *= 10;
							sum += arr[x][y];

							if (Math.sqrt(sum) % 1 == 0) {
								res = Math.max(res, sum);
							}

							x += a;
							y += b;
						}
					}
				}
			}
		}
		
		System.out.println(res);
	}
}