import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		int[] color = new int[m];
		for (int i = 0; i < m; i++) {
			color[i] = stoi.apply(in.readLine());
		}

		int s = 1;
		int e = (int) 1e9;
        
		while (s < e) {
			int mid = (s + e) >> 1;
			int cnt = 0;
		
            for (int i = 0; i < m; i++) {
				cnt += color[i] / mid;

				if (color[i] % mid > 0) {
					cnt++;
				}
			}

			if (cnt <= n) {
				e = mid ;
			} else {
				s = mid + 1;
			}

		}
		System.out.println(e);
	}
}