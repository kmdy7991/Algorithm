import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int n, m;
	static int[][] talk;
	static int[][] bridge;
	static int[] position;
	static Set<Integer>[] flower;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = stoi.apply(st.nextToken());
		m = stoi.apply(st.nextToken());

		talk = new int[n][4];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			talk[i][0] = stoi.apply(st.nextToken());
			talk[i][1] = stoi.apply(st.nextToken());
			talk[i][2] = stoi.apply(st.nextToken());
			talk[i][3] = stoi.apply(st.nextToken());
		}

		flower = new HashSet[n];
		for (int i = 0; i < n; i++) {
			flower[i] = new HashSet<>();

			st = new StringTokenizer(in.readLine());
			while (st.hasMoreTokens()) {
				flower[i].add(stoi.apply(st.nextToken()) - 1);
			}
		}

		bridge = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());

			bridge[i][0] = stoi.apply(st.nextToken()) - 1;
			bridge[i][1] = stoi.apply(st.nextToken()) - 1;
			bridge[i][2] = stoi.apply(st.nextToken()) - 1;
		}

		position = new int[n];
		findPosition(new boolean[n], 0);

		System.out.println("NO");
	}

	private static void findPosition(boolean[] visited, int cur) {
		if (cur == visited.length) {
			boolean flag = true;
            
			for (int i = 0; i < m; i++) {
				if (talk[position[bridge[i][0]]][bridge[i][2]] != talk[position[bridge[i][1]]][bridge[i][2]]) {
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println("YES");

				for (int i = 0; i < n; i++) {
					System.out.print((position[i] + 1) + " ");
				}
				System.exit(0);
			}

			return;
		}

		for (int v : flower[cur]) {
			if (!visited[v]) {
				visited[v] = true;
				position[v] = cur;
				findPosition(visited, cur + 1);
				visited[v] = false;
			}
		}
	}
}