import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int[][] triangle = init();

		int r = stoi.apply(st.nextToken());
		int c = stoi.apply(st.nextToken());
		int w = stoi.apply(st.nextToken());

		int sum = 0;

		for (int i = 0; i < w; i++) {
			for (int j = 0; j <= i; j++) {
				sum += triangle[i + r][j + c];
			}
		}
        
		System.out.println(sum);
	}

	private static int[][] init() {
		int[][] arr = new int[32][32];
		arr[1][1] = 1;

		for (int i = 2; i < 31; i++) {
			for (int j = 1; j <= i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}
		return arr;
	}
}