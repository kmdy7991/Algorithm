import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());
        
		Set<Integer> store = new HashSet<>();

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			store.add(stoi.apply(st.nextToken()));
		}

		int m = stoi.apply(in.readLine());

		int[] index = new int[m];
		
        st = new StringTokenizer(in.readLine());
		for (int i = 0; i < m; i++) {
			if (store.contains(stoi.apply(st.nextToken()))) {
				index[i] = 1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int idx : index) {
			sb.append(idx).append(" ");
		}
		System.out.print(sb);
	}
}