import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Deque<Integer> stack = new ArrayDeque<>();

		int n = stoi.apply(in.readLine());
		
		long res = 0;
		for (int i = 0; i < n; i++) {
			int num = stoi.apply(in.readLine());
			
			while(!stack.isEmpty() && stack.peekLast() <= num ) {
				stack.pollLast();
			}
			
			if(!stack.isEmpty()) {
				res += stack.size();
			}
			
			stack.offerLast(num);
		}
		
		System.out.print(res);
	}
}