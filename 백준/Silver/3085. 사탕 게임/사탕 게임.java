import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = in.readLine().toCharArray();
		}

		change(map, n);
	}

	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	private static void change(char[][] map, int n) {
		int res = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				for (int d = 0; d < 2; d++) {
					int nr = i + dx[d];
					int nc = j + dy[d];

					if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
						continue;
					}

					if (map[i][j] != map[nr][nc]) {
						swap(i, j, nr, nc, map);
						res = Math.max(res, sum(map, n));
						swap(i, j, nr, nc, map);
					}
				}
			}
		}

		System.out.print(res);
	}

	private static int sum(char[][] map, int n) {
		int cnt = 1;
		int maxCnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					cnt++;
				} else {
					cnt = 1;
				}
                
				maxCnt = Math.max(maxCnt, cnt);
			}
			
			cnt = 1;

			for (int j = 0; j < n - 1; j++) {
				if (map[j][i] == map[j + 1][i]) {
					cnt++;
				} else {
					cnt = 1;
				}
                
				maxCnt= Math.max(maxCnt, cnt);
			}
            
			cnt = 1;
		}

		return maxCnt;
	}

	private static void swap(int i, int j, int nr, int nc, char[][] map) {
		char temp = map[i][j];
		map[i][j] = map[nr][nc];
		map[nr][nc] = temp;
	}
}