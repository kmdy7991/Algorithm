import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int h = stoi.apply(st.nextToken());

		int[] top = new int[h + 1];
		int[] bottom = new int[h + 1];

		for (int i = 0; i < (n >> 1); i++) {
			bottom[stoi.apply(in.readLine())]++;
			top[stoi.apply(in.readLine())]++;
		}

		for (int i = h - 1; i >= 1; i--) {
			bottom[i] += bottom[i + 1];
			top[i] += top[i + 1];
		}

		int cnt = 1;
		int min = n;
		for (int i = 1; i <= h; i++) {
			if (min > bottom[i] + top[h - i + 1]) {
				min = bottom[i] + top[h - i + 1];
				cnt = 1;
			} else if(min == bottom[i] + top[h - i + 1]) {
				cnt++;
			}
		}

		System.out.print(min + " " + cnt);
	}
}