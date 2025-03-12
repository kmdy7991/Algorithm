import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		int[][] map = new int[n][m];

		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = stoi.apply(st.nextToken());
				visited[i][j] = -1;
			}
		}

		search(0, 0, map, n, m);
		System.out.print(visited[0][0]);
	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static int search(int r, int c, int[][] map, int n, int m) {
		if (r == n - 1 && c == m - 1) {
			return 1;
		}

		if (visited[r][c] != -1) {
			return visited[r][c];
		}
		
		visited[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];

			if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
				continue;
			}
			
			if (map[nr][nc] < map[r][c]) {
				visited[r][c] += search(nr, nc, map, n, m);
			}
		}

		return visited[r][c];
	}
}