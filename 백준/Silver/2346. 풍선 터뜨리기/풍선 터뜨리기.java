import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static class Node {
		int idx;
		int point;

		Node(int idx, int point) {
			this.idx = idx;
			this.point = point;
		}
	}

	static Function<String, Integer> stoi = Integer::parseInt;
	static Deque<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		q = new ArrayDeque<>();
		int n = stoi.apply(in.readLine());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			q.offer(new Node(i + 1, stoi.apply(st.nextToken())));
		}

		Node first = q.pollFirst();

		sb.append(first.idx).append(" ");
		int cur = first.point;

		while (!q.isEmpty()) {
			if (cur > 0) {
				while (cur-- > 0) {
					q.offerLast(q.pollFirst());
				}
				Node now = q.pollLast();
				cur = now.point;
				sb.append(now.idx).append(" ");
			} else {
				while (cur++ < 0) {
					q.offerFirst(q.pollLast());
				}
				Node now = q.pollFirst();
				cur = now.point;
				sb.append(now.idx).append(" ");
			}
		}
		System.out.println(sb);
	}
}