import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Deque<Integer> stack = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();
		
		int n = stoi.apply(in.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			
			String order = st.nextToken();
			switch(order) {
			case "push":
				stack.offerLast(stoi.apply(st.nextToken()));
				break;
			case "pop":
				sb.append(stack.isEmpty() ? -1 : stack.pollLast()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
				break;
			case "top":
				sb.append(stack.isEmpty() ? -1 : stack.peekLast()).append("\n");
				break;
			}
		}

		System.out.print(sb);
	}
}