import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static final String ENTER = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());
		Deque<Integer> q = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			switch (st.nextToken()) {
			case "push":
				q.offer(stoi.apply(st.nextToken()));
				break;
			case "pop":
				if (q.isEmpty()) {
					sb.append(-1).append(ENTER);
				} else {
					sb.append(q.pollFirst()).append(ENTER);
				}
				break;
			case "size":
				sb.append(q.size()).append(ENTER);
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0).append(ENTER);
				break;
			case "front":
				sb.append(q.isEmpty() ? -1 : q.peekFirst()).append(ENTER);
				break;
			case "back":
				sb.append(q.isEmpty() ? -1 : q.peekLast()).append(ENTER);
				break;
			}
		}
		System.out.println(sb);
	}
}
