import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static List<String> store;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = stoi.apply(in.readLine());


		arr = new char[n];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		store = new ArrayList<>();
		find(0, 0, n, new int[n + 1], new boolean[10]);
		
		System.out.println(store.get(store.size() - 1));
		System.out.print(store.get(0));

	}

	private static void find(int cnt, int idx, int n, int[] nums, boolean[] visited) {
		if(cnt == n + 1) {
			boolean flag = true;
			
			for(int i = 0; i < n; i++) {
				if(arr[i] == '>') {
					if(nums[i] < nums[i + 1]) {
						flag = false;
						break;
					}
					
				}
				
				if(arr[i] == '<') {
					if(nums[i] > nums[i + 1]) {
						flag = false;
						break;
					}
				}
			}
			
			for(int num : nums) {
				sb.append(num);
			}
			
			if(flag) {
				store.add(sb.toString());
			}
			sb.setLength(0);
			return;
		}
		
		
		for(int i = 0; i < 10; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			nums[cnt] = i;
			find(cnt + 1, i + 1, n, nums, visited);
			visited[i] = false;
		}
	}
}