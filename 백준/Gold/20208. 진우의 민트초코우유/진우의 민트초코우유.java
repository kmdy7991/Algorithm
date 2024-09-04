import java.io.*;
import java.util.*;
import java.util.function.Function;

class Milk {
	int r;
	int c;

	Milk(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int h;
	static int[] home;
	static int[] idx;
	static List<Milk> milks;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());
		h = stoi.apply(st.nextToken());

		home = new int[2];

		milks = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 0; j < n; j++) {
				int num = stoi.apply(st.nextToken());

				if (num == 1) {
					home[0] = i;
					home[1] = j;
				} else if (num == 2) {
					milks.add(new Milk(i, j));
				}
			}
		}

		perm(home[0], home[1], 0, m, new boolean[milks.size()]);
		System.out.print(res);
	}

	static int res = 0;

	private static void perm(int r, int c, int cnt, int health, boolean[] visited) {
		int backHome = health - distance(home[0], r, home[1], c);

		if (backHome >= 0) {
			res = Math.max(cnt, res);
		}
		
		for (int i = 0; i < milks.size(); i++) {
			if (visited[i]) {
				continue;
			}
			
			Milk cur = milks.get(i);
			int dist = health - distance(r, cur.r, c, cur.c);
			if(dist < 0) {
				continue;
			}
			visited[i] = true;
			perm(cur.r, cur.c, cnt + 1, dist + h, visited);
			visited[i] = false;
		}
	}

	private static int distance(int r, int nr, int c, int nc) {
		return Math.abs(r - nr) + Math.abs(c - nc);
	}
}