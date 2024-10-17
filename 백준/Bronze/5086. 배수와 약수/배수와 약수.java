import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
        
		while (true) {
			st = new StringTokenizer(in.readLine());
            
			int n = stoi.apply(st.nextToken());
			int m = stoi.apply(st.nextToken());

			if (n + m == 0) {
				System.out.print(sb);
				return;
			}

			if (n > m && n % m == 0) {
				sb.append("multiple").append("\n");
				continue;
			}
			
			if (n < m && m % n == 0) {
				sb.append("factor").append("\n");
				continue;
			}
			
			sb.append("neither").append("\n");
		}
	}
}