import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		st = new StringTokenizer(in.readLine());
		
		int[] tower = new int[n];
		for (int i = 0; i < n; i++) {
			tower[i] = stoi.apply(st.nextToken());
		}
		
        Deque<Integer> stack = new ArrayDeque<>();
        
		int[] detact = new int[n];
		for (int i = 0; i < n; i++) {
			
			while(!stack.isEmpty()) {
				if (tower[stack.peekLast()] < tower[i]) {
					stack.pollLast();
				} else {
					detact[i] =stack.peekLast()+ 1;
					break;
				}
			}

			stack.offerLast(i);
		}
		
		StringBuilder sb = new StringBuilder();
        
		for(int num : detact) {
			sb.append(num).append(" ");
		}
		
		System.out.print(sb);
	}
}