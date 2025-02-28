import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static boolean flag = true;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = stoi.apply(in.readLine());

        List<Integer>[] list;
		int[] color;

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			st = new StringTokenizer(in.readLine());

			int v = stoi.apply(st.nextToken());
			int e = stoi.apply(st.nextToken());

			list = new ArrayList[v];

			for (int i = 0; i < v; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(in.readLine());

				int from = stoi.apply(st.nextToken()) - 1;
				int to = stoi.apply(st.nextToken()) - 1;

				list[from].add(to);
				list[to].add(from);
			}

			color = new int[v];

			for (int i = 0; i < v; i++) {
				if (!flag) {
					break;
				}
				if (color[i] == 0) {
					divideGraph(list, color, i, 1);
				}
			}

			sb.append(flag ? "YES" : "NO").append("\n");
			flag = true;
		}
		System.out.print(sb);
	}

	private static void divideGraph(List<Integer>[] list, int[] color, int idx, int fill) {
		if (!flag) {
			return;
		}

		color[idx] = fill;

		for (int num : list[idx]) {
			if (fill == color[num]) {
				flag = false;
				return;
			}

			if (color[num] == 0) {
				divideGraph(list, color, num, -fill);
			}
		}
	}
}