import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi.apply(in.readLine());
		if(n == 0) {
			System.out.print(0);
			return;
		}
		
		System.out.println(fibo(n));
	}

	private static int fibo(int n) {
		if(n <= 2) {
			return 1;
		}
		
		return fibo(n - 1) + fibo(n - 2);
	}
}