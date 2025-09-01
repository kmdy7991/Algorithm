import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int[][] points = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			
			points[i][0] = stoi.apply(st.nextToken());
			points[i][1] = stoi.apply(st.nextToken());
		}
		
		Arrays.sort(points, Comparator.comparingInt((int[] p) -> p[0])
		                             .thenComparingInt((int[] p) -> p[1]));
		
		StringBuilder sb = new StringBuilder();
		for (int[] point: points) {
			sb.append(point[0]).append(" ").append(point[1]).append("\n");
		}

		System.out.print(sb);
	}
}