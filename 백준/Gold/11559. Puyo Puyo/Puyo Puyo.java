import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static char[][] map;
	static boolean[][] visited;
	static List<int[]> store;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new char[12][];

		for (int i = 0; i < 12; i++) {
			map[i] = in.readLine().toCharArray();
		}

		int res = 0;

		store = new ArrayList<>();

		while (true) {
			visited = new boolean[12][6];

			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.' && !visited[i][j]) {
						find(i, j, map[i][j]);
					}
				}
			}

			if (store.size() == 0) {
				break;
			}

			explose();

			gravity();

			res++;
		}

		System.out.println(res);
	}

	private static void explose() {
		for (int[] cur : store) {
			map[cur[0]][cur[1]] = '.';
		}

		store.clear();
	}

	private static void gravity() {
		for (int i = 10; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != '.' && map[i + 1][j] == '.') {
					int cnt = i;
					
					while (cnt + 1 < 12 && map[cnt + 1][j] == '.') {
						map[cnt + 1][j] = map[cnt][j];
						map[cnt++][j] = '.';
					}
				}
			}
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void find(int r, int c, char color) {
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> temp = new ArrayList<>();

		q.offer(new int[] { r, c });
		temp.add(q.peek());

		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dx[i];
				int nc = cur[1] + dy[i];

				if (nr < 0 || nc < 0 || nr >= 12 || nc >= 6 || visited[nr][nc]) {
					continue;
				}

				if (map[nr][nc] == color) {
					int[] next = { nr, nc };
					visited[nr][nc] = true;

					q.offer(next);
					temp.add(next);
				}
			}
		}

		if (temp.size() >= 4) {
			for (int[] tmp : temp) {
				store.add(tmp);
			}
		}
	}
}