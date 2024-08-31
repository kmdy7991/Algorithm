import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int n, m;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = stoi.apply(st.nextToken());
		m = stoi.apply(st.nextToken());

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = in.readLine().toCharArray();
		}

		int sheep = 0;
		int wolf = 0;

		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] != '#') {
					int[] res = fight(i, j);

					if (res[0] > res[1]) {
						sheep += res[0];
					} else {
						wolf += res[1];
					}
				}
			}
		}
		System.out.print(sheep + " " + wolf);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int[] fight(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { r, c });
		visited[r][c] = true;

		int sheep = 0;
		int wolf = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (map[cur[0]][cur[1]] == 'o') {
				sheep++;
			} else if (map[cur[0]][cur[1]] == 'v') {
				wolf++;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dx[i];
				int nc = cur[1] + dy[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] || map[nr][nc] == '#') {
					continue;
				}

				visited[nr][nc] = true;
				q.offer(new int[] { nr, nc });
			}
		}

		return new int[] { sheep, wolf };
	}
}