import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi.apply(in.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = stoi.apply(in.readLine());
		}

		int left = 0;
		int cur = -1;
		for (int i = 0; i < n; i++) {
			if (cur < arr[i]) {
				cur = arr[i];
				left++;
			}
		}
        
		int right = 0;
		cur = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (cur < arr[i]) {
				cur = arr[i];
				
				right++;
			}
		}

		System.out.print(left + "\n" + right);
	}
}