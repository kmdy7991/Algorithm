import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int n, m, dis;
	static int[][] map;
	static List<int[]> p = new ArrayList<>();
	static List<int[]> c = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		input();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = stoi.apply(st.nextToken());
		m = stoi.apply(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
					       .mapToInt(stoi::apply).toArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) p.add(new int[] { i, j });
				if (map[i][j] == 2) c.add(new int[] { i, j });
			}
		}
        
		dis = (int) 1e9;
		survive(0, 0, new int[m]);
		bw.write(dis+"");
        bw.close();
	}

	private static void survive(int cnt, int idx, int[] p) {
		if (cnt == m) {
			dis = Math.min(dis, getDis(p));
			return;
		}
		for (int i = idx; i < c.size(); i++) {
			p[cnt] = i;
			survive(cnt + 1, i + 1, p);
		}
	}

	private static int getDis(int[] chicken) {
		int tmp = 0;
		for (int[] h : p) {
			int current = (int) 1e9;
			for (int ch : chicken) {
				current = Math.min(current, Math.abs(h[0] - c.get(ch)[0]) + Math.abs(h[1] - c.get(ch)[1]));
			}
			tmp += current;
		}
		return tmp;
	}
}