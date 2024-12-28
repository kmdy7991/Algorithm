import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int k = stoi.apply(st.nextToken());
		Deque<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= n; i++ ) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder("<");
		int cnt = 0;
		while(!q.isEmpty()) {
			int num = q.pollFirst();
			cnt++;
			
			if(cnt % k == 0) {
				sb.append(num).append(", ");
				continue;
			}
			q.addLast(num);
		}
        
		sb.setLength(sb.length() - 2);
		sb.append(">");
        
		System.out.println(sb);
	}
}