import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int r = 0;
		int c = 0;
		int max = -1;
		
		int[][] nums = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < 9; j++) {
				nums[i][j] = stoi.apply(st.nextToken());
				if(nums[i][j] > max) {
					r = i + 1;
					c = j + 1;
					max = nums[i][j];
				}
			}
		}
		System.out.print(String.format("%d\n%d %d", max, r, c));
	}
}