import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = stoi.apply(in.readLine());

		while (t-- > 0) {
			st = new StringTokenizer(in.readLine());

			int n = stoi.apply(st.nextToken());
			int m = stoi.apply(st.nextToken());
			int k = stoi.apply(st.nextToken());

			int[][] map = new int[n][m];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());

				int x = stoi.apply(st.nextToken());
				int y = stoi.apply(st.nextToken());

				map[x][y] = -1;
			}

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == -1) {
						positionBug(n, m, map, i, j, cnt++);
					}
				}
			}

			System.out.println(cnt);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void positionBug(int n, int m, int[][] map, int r, int c, int count) {
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { r, c });
		map[r][c] = count;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dx[i];
				int nc = cur[1] + dy[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
					continue;
				}

				if (map[nr][nc] == -1) {
					map[nr][nc] = count;
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}
}
