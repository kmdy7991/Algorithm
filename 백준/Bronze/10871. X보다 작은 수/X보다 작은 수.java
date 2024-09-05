import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int x = stoi.apply(st.nextToken());

		st = new StringTokenizer(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int num = stoi.apply(st.nextToken());
            
			if(num < x) {
				sb.append(num).append(" ");
			}
		}
		System.out.println(sb);
	}
}