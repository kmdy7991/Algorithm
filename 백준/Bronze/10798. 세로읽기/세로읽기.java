import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		char[][] alpha = new char[5][15];
		for (int i = 0; i < 5; i++) {
			String line = in.readLine();
            
			for (int j = 0; j < line.length(); j++) {
				alpha[i][j] = line.charAt(j);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (alpha[j][i] == '\u0000') {
					continue;
				}
				
				sb.append(alpha[j][i]);
			}
		}
		System.out.println(sb);
	}
}