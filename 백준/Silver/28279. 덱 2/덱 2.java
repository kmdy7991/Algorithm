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

		StringBuilder sb = new StringBuilder();

		Deque<String> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			switch (st.nextToken()) {
			case "1":
				q.offerFirst(st.nextToken());
				break;
			case "2":
				q.offerLast(st.nextToken());
				break;
			case "3":
				sb.append(q.isEmpty() ? "-1" : q.pollFirst()).append(ENTER);
				break;
			case "4":
				sb.append(q.isEmpty() ? "-1" : q.pollLast()).append(ENTER);
				break;
			case "5":
				sb.append(q.size()).append(ENTER);
				break;
			case "6":
				sb.append(q.isEmpty() ? 1 : 0).append(ENTER);
				break;
			case "7":
				sb.append(q.isEmpty() ? "-1" : q.peekFirst()).append(ENTER);
				break;
			case "8":
				sb.append(q.isEmpty() ? "-1" : q.peekLast()).append(ENTER);
				break;

			}
		}
		System.out.println(sb);
	}
}
