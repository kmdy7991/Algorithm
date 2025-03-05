import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		int[] square = new int[n];
		int[][] count = new int[8001][2];

		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += square[i] = Integer.parseInt(in.readLine());

			int temp = square[i];
			if (square[i] < 0) {
				temp = 4000 - temp;
			}
			count[temp][0] = square[i];
			count[temp][1]++;
		}

		Arrays.sort(square);
		Arrays.sort(count, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o2[1] - o1[1];
		});

		int avg = (int) Math.round(sum / n);
		int mid = square[n == 1 ? 0 : (n >> 1)];
		int coverage = n == 1 ? count[0][0] : count[0][1] == count[1][1] ? count[1][0] : count[0][0];
		int diff = square[n - 1] - square[0];

		System.out.println(avg + "\n" + mid + "\n" + coverage + "\n" + diff);
	}
}
