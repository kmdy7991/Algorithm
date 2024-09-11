import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi.apply(in.readLine());

		int space = n;
		int star = 1;
		for (int i = 1; i < (n << 1); i++, star = i > n ? star - 2 : star + 2) {
			if(i <= n) {
				space--;
			} else if (i > n) {
				space++;
			}

			for (int j = 0; j < star + space; j++) {
				if(j < space) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}