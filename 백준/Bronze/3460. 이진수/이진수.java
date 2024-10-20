import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int t = stoi.apply(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(t-- > 0) {
			int n = stoi.apply(in.readLine());
			
			String binary = Integer.toBinaryString(n);
			
			int cnt = 0;
			for (int i = binary.length() - 1; i >= 0; i--) {
				if(binary.charAt(i) == '1') {
					sb.append(cnt).append(" ");
				}
				cnt++;
			}
			sb.append("\n");
		}
        
		System.out.print(sb);
	}
}