import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());
		char[][] map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = in.readLine().toCharArray();
		}

		find(n, map);
	}

	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	private static void find(int n, char[][] map) {
		int candy = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				for (int d = 0; d < 2; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
						continue;
					}

					if (map[i][j] != map[nx][ny]) {
						swap(map, i, j, nx, ny);
						candy = Math.max(candy, count(n,candy, map));
						swap(map, i, j, nx, ny);
					}
				}
			}
		}

		System.out.print(candy);
	}

	private static void swap(char[][] map, int r, int c, int nr, int nc) {
		char temp = map[r][c];
		map[r][c] = map[nr][nc];
		map[nr][nc] = temp;
	}

	private static int count(int n, int candy, char[][] map) {
		int max = -1;
		
		for (int i = 0; i < n; i++) {
			int idx = 1;
			int item = 1;
			
			while (idx < n) {
				if (map[i][idx - 1] != map[i][idx++]) {
					item = 1;
					continue;
				}
				
				max = Math.max(max, ++item);
			}

			idx = 1;
			item = 1;
            
			while (idx < n) {
				if (map[idx - 1][i] != map[idx++][i]) {
					item = 1;
					continue;
				}
				
				max = Math.max(max, ++item);
			}
		}
		
		return max;
	}
}