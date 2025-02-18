import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int[] buildTime;
	static int[] buildCount;
	static int[] totalTime;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		buildTime = new int[n];
		buildCount = new int[n];
		totalTime = new int[n];

		List<Integer>[] order = new ArrayList[n];
        for (int i = 0; i < n; i++){
            order[i] = new ArrayList<>();
        }
        
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			buildTime[i] = stoi.apply(st.nextToken());

			int idx = 0;
			while ((idx = stoi.apply(st.nextToken())) != -1) {
				order[idx - 1].add(i);
				buildCount[i]++;
			}
		}
        
		System.out.println(topology(n, order));
	}

	private static StringBuilder topology(int n, List<Integer>[] order) {
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			if (buildCount[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int prev = q.poll();

			for (int cur : order[prev]) {
				totalTime[cur] = Math.max(totalTime[cur], totalTime[prev] + buildTime[prev]);
				if (--buildCount[cur] == 0) {
					q.offer(cur);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(totalTime[i] + buildTime[i]).append("\n");
		}
		
		return sb;
	}
}