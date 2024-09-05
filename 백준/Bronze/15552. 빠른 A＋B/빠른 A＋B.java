import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int t = stoi.apply(in.readLine());
		
		while(t--> 0) {
			st = new StringTokenizer(in.readLine());
			
			sb.append(stoi.apply(st.nextToken()) + stoi.apply(st.nextToken())).append("\n");
		}

		System.out.println(sb);
	}
}