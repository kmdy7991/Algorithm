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
		Deque<Character> stack = new ArrayDeque<>();
		while(n-- > 0) {
			char[] ps = in.readLine().toCharArray();
			
			String answer = "NO";

			boolean flag = true;
			for(char p : ps) {
				if(p == ')') {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}
					stack.pollLast();
					continue;
				}
				
				stack.push(p);
			}
			answer = flag && stack.size() == 0 ? "YES" : answer;
			sb.append(answer).append(ENTER);
			stack.clear();
		}
		System.out.println(sb);
	}
}
