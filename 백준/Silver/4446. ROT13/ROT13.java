import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		char[] mom = { 'A', 'I', 'Y', 'E', 'O', 'U' };
		char[] child = { 'B', 'K', 'X', 'Z', 'N', 'H', 'D', 'C', 'W', 'G', 'P', 'V', 'J', 'Q', 'T', 'S', 'R', 'L', 'M',
				'F' };
        
		StringBuilder sb = new StringBuilder();
        
        String line;
		while ((line = in.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
                
				char c = line.charAt(i);
				if (c == '.' || c == ' ') {
					sb.append(c);
					continue;
				}

				int idx = 0;
				if (Character.isAlphabetic(c)) {
					char upper = Character.toUpperCase(c);
                    
					if (charUpper(upper)) {
						for (int j = 0; j < mom.length; j++) {
							if (mom[j] == upper) {
								idx = j;
								break;
							}
						}
						idx = idx - 3 < 0 ? mom.length + (idx - 3) : idx - 3;
						
                        sb.append(Character.isLowerCase(c) ? Character.toLowerCase(mom[idx]) : mom[idx]);
					} else {
						for (int j = 0; j < child.length; j++) {
							if (child[j] == upper) {
								idx = j;
								break;
							}
						}
                        idx = idx - 10 < 0 ? child.length + (idx - 10) : idx - 10;
						
                        sb.append(Character.isLowerCase(c) ? Character.toLowerCase(child[idx]) : child[idx]);
					}
				} else {
					sb.append(c);
				}
			}
			sb.append("\n");
		}
        
		System.out.println(sb);
	}

	private static boolean charUpper(char c) {
		return c == 'A' || c == 'I' || c == 'Y' || c == 'E' || c == 'O' || c == 'U';
	}
}