import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static boolean[] visited;
	static List<Integer>[] graph;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());
		int v = stoi.apply(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());

			int s = stoi.apply(st.nextToken());
			int e = stoi.apply(st.nextToken());

			graph[s].add(e);
			graph[e].add(s);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}
		
		sb = new StringBuilder();
		visited = new boolean[n + 1];

		dfs(v);
		
		sb.append("\n");

		Arrays.fill(visited, false);
		
		bfs(v);

		System.out.println(sb);
	}

	private static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[v] = true;
		q.add(v);

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");

			for (int num : graph[cur]) {
				if (!visited[num]) {
					q.offer(num);
					visited[num] = true;
				}
			}
		}
	}

	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");

		for (int num : graph[v]) {
			if (!visited[num]) {
				dfs(num);
			}
		}
	}
}
