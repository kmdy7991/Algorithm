import java.io.*;
import java.util.*;
import java.util.function.Function;

class Node {
	int e;
	int v;

	Node(int e, int v) {
		this.e = e;
		this.v = v;
	}
}

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int n, k;
	static int[] friend;
	static int[][] dist;
	static List<Node>[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		map = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());

			int s = stoi.apply(st.nextToken());
			int e = stoi.apply(st.nextToken());
			int v = stoi.apply(st.nextToken());

			map[s].add(new Node(e, v));
		}

		k = stoi.apply(in.readLine());

		friend = new int[k];
		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < k; i++) {
			friend[i] = stoi.apply(st.nextToken());
		}

		dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		for (int i = 1; i <= n; i++) {
			minimumPath(i);
		}

		findCity().forEach(i -> System.out.print(i + " "));
	}

	private static List<Integer> findCity() {
		Queue<Integer> path = new PriorityQueue<>();
		int res = (int) 2e9 + 1;

		List<Integer> city = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int max = -1;
			for (int f : friend) {
				max = Math.max(dist[i][f] + dist[f][i], max);
			}

			if (max < res) {
				city.clear();
				city.add(i);
				res = max;
			} else if (max == res) {
				city.add(i);
			}
		}

		return city;
	}

	private static void minimumPath(int i) {
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.v));
		pq.offer(new Node(i, 0));
		dist[i][i] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[i][cur.e] < cur.v) {
				continue;
			}

			for (Node next : map[cur.e]) {
				if (dist[i][next.e] > cur.v + next.v) {
					dist[i][next.e] = cur.v + next.v;
					pq.offer(new Node(next.e, dist[i][next.e]));
				}
			}
		}

	}
}