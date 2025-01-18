import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static final char NULL = '\u0000';

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		char[][] map = new char[n + 3][m + 3];

		for (int i = 1; i <= n; i++) {
			String line = in.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}

		map = puzzle(n, m, map);

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'o') {
					cnt++;
					sb.append(i + " " + j).append("\n");
				}
			}
		}

		System.out.println(cnt);
		System.out.print(sb);
	}

	private static char[][] puzzle(int n, int m, char[][] map) {
		char change = 'o';

		char[][] copy = Arrays.stream(map).map(char[]::clone).toArray(char[][]::new);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (map[i][j] == '.') {
					if (map[i][j - 1] == NULL || map[i][j - 1] == '#') {
						if (map[i][j + 1] == '.' && map[i][j + 2] == '.') {
							copy[i][j] = change;
						}
					}
				}

				if (map[i][j] == '.') {
					if (map[i - 1][j] == NULL || map[i - 1][j] == '#') {
						if (map[i + 1][j] == '.' && map[i + 2][j] == '.') {
							copy[i][j] = change;
						}
					}
				}
			}
		}
		return copy;
	}
}