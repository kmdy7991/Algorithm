import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static Set<String> sequence;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = stoi.apply(st.nextToken());
		}

		Arrays.sort(arr);

		sb = new StringBuilder();
		sequence = new HashSet<>();
		numSequence(arr, 0, m, new int[m]);

		System.out.print(sb);
	}

	private static void numSequence(int[] arr, int cnt, int target, int[] store) {
		if (cnt == target) {
			StringBuilder temp = new StringBuilder();
			
            for (int i = 0; i < target; i++) {
				temp.append(store[i]).append(" ");
			}
			
			if(!sequence.contains(temp.toString())) {
				sequence.add(temp.toString());
				sb.append(temp.toString()).append("\n");
			}
			return;
		}

        for (int i = 0; i < arr.length; i++) {
			store[cnt] = arr[i];
			numSequence(arr, cnt + 1, target, store);
		}
	}
}