import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int n, m, h;
	static int[][][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		m = stoi.apply(st.nextToken());
		n = stoi.apply(st.nextToken());
		h = stoi.apply(st.nextToken());

		Queue<int[]> q = new ArrayDeque<>();

		map = new int[h][n][m];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(in.readLine());

				for (int k = 0; k < m; k++) {
					map[i][j][k] = stoi.apply(st.nextToken());
                    
					if (map[i][j][k] == 1) {
						q.offer(new int[] { i, j, k });
					}
				}
			}
		}

		tomato(q);

		System.out.println(findZero() ? days - 1 : -1);
	}

	private static boolean findZero() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	static int days = 0;

	private static void tomato(Queue<int[]> q) {
		int[] dz = { -1, 1, 0, 0, 0, 0 };
		int[] dx = { 0, 0, -1, 1, 0, 0 };
		int[] dy = { 0, 0, 0, 0, -1, 1 };

		boolean[][][] visited = new boolean[h][n][m];

		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				int[] cur = q.poll();

				for (int i = 0; i < 6; i++) {
					int nz = cur[0] + dz[i];
					int nr = cur[1] + dx[i];
					int nc = cur[2] + dy[i];

					if (nz < 0 || nr < 0 || nc < 0 || nz >= h || nr >= n || nc >= m) {
						continue;
					}

					if (!visited[nz][nr][nc] && map[nz][nr][nc] == 0) {
						map[nz][nr][nc] = 1;
						visited[nz][nr][nc] = true;
						q.offer(new int[] { nz, nr, nc });
					}
				}
			}

			days++;
		}
	}
}