import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int idx = 0;
		int max = -(int) 1e9;
		for (int i = 0; i < 9; i++) {
			int n = stoi.apply(in.readLine());
			
			if(max < n) {
				idx = i;
				max = n;
			}
		}

		System.out.print(max + "\n" + (idx + 1));
	}
}