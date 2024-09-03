import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int n, h, res;
	static boolean[][] ladder;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());
		h = stoi.apply(st.nextToken());

		ladder = new boolean[h][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());

			int a = stoi.apply(st.nextToken());
			int b = stoi.apply(st.nextToken());

			ladder[a - 1][b] = true;
		}

		res = 4;
		
		for (int i = 0; i < res; i++) {
			game(0, 1, 0, i);
		}

		System.out.println(res == 4 ? -1 : res);
	}

	private static boolean result() {
		for (int i = 1; i <= n; i++) {
			int line = i;

			for (int j = 0; j < h; j++) {
				if (line + 1 <= n && ladder[j][line]) {
					line++;
				} else if (line - 1 > 0 && ladder[j][line - 1]) {
					line--;
				}
			}

			if (line != i) {
				return false;
			}
		}

		return true;
	}

	private static void game(int r, int c, int cnt, int maxCnt) {
		if (cnt == maxCnt) {
            if(result()) {
                res = Math.min(cnt, res);
            }
			return;
		}

		for (int i = r; i < h; i++, c = 1) {
			for (int j = c; j < n; j++) {
				if (ladder[i][j - 1] || ladder[i][j] || ladder[i][j + 1]) {
					continue;
				}

				ladder[i][j] = true;
				game(i, j, cnt + 1, maxCnt);
				ladder[i][j] = false;
			}
		}
	}
}