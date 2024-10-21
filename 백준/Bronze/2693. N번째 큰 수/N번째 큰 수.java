import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int t = stoi.apply(in.readLine());
		
		while(t--> 0) {
			int[] arr = new int[10];
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < 10; i++) {
				arr[i] = stoi.apply(st.nextToken());
			}
			Arrays.sort(arr);
			
			System.out.println(arr[7]);
		}
	}
}