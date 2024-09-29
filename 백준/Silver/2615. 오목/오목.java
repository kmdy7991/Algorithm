import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = 21;
		int m = 19;

		int[][] map = new int[n][n];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 1; j <= m; j++) {
				map[i][j] = stoi.apply(st.nextToken());
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[j][i] != 0) {
					if (findWinner(m, j, i, map[j][i], map)) {
						System.out.print(String.format("%d\n%d %d", map[j][i], j, i));
						return;
					}
				}
			}
		}
        System.out.print(0);
	}

	static int[] dx = { 1, 0, -1, 1 };
	static int[] dy = { 0, 1, 1, 1 };

	private static boolean findWinner(int m, int r, int c, int target, int[][] map) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i] * 4;
			int nc = c + dy[i] * 4;

			if (!isValid(m, nr, nc)) {
				continue;
			}
			
			if (map[nr + dx[i]][nc + dy[i]] != target) {
				int cnt = 5;
				
				while (map[nr][nc] == target) {
					nr -= dx[i];
					nc -= dy[i];
					cnt--;
				}
                
				if (cnt == 0) {
					return true;
				}
			}
		}
        
		return false;
	}

	private static boolean isValid(int m, int r, int c) {
		return r >= 1 && c >= 1 && r <= m && c <= m;
	}
}