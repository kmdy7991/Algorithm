import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		int n = stoi.apply(in.readLine());
		
		for(int i = 1; i < n / 4; i++) {
			sb.append("long ");
		}
		sb.append("long int");
        
		System.out.println(sb);
	}
}