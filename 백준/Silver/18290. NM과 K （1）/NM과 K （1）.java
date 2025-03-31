import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int[][] map;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());
		int k = stoi.apply(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = stoi.apply(st.nextToken());
			}
		}

		res = -(int) 1e7;
		find(0, 0, 0, 0, k, new boolean[n][m]);

		System.out.print(res);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void find(int r, int c, int sum, int cnt, int k, boolean[][] visited) {
		if (cnt == k) {
			res = Math.max(res, sum);
			return;
		}

		for (int i = r; i < visited.length; i++) {
			for (int j = (r == i) ? c : 0; j < visited[0].length; j++) {
				if (visited[i][j]) {
					continue;
				}

				boolean flag = true;
                
				for (int d = 0; d < 4; d++) {
					int nr = i + dx[d];
					int nc = j + dy[d];
					if ((nr >= 0 && nc >= 0 && nr < visited.length && nc < visited[0].length) && visited[nr][nc]) {
						flag = false;
						break;
					}
				}

				if (flag) {
					visited[i][j] = true;
					find(i, j, sum + map[i][j], cnt + 1, k, visited);
					visited[i][j] = false;
				}
			}
		}
	}
}