import java.io.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static char[][] wheel;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[31];
		
		for (int i = 0; i < 28; i++) {
			arr[stoi.apply(in.readLine())]++;
		}

		for (int i = 1; i < 31; i++) {
			if(arr[i] == 0) {
				System.out.println(i);
			}
		}
	}
}