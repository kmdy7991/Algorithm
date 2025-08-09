import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int sum = 0;

		int[] nums = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = stoi.apply(in.readLine());
			sum += nums[i];
		}

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - (nums[i] + nums[j]) == 100) {
					nums[i] = -1;
					nums[j] = -1;
	
                    Arrays.sort(nums);
		
                    for (int k = 2; k < 9; k++) {
                        System.out.println(nums[k]);
                    }
                    
                    return;
				}
			}
		}
	}
}
