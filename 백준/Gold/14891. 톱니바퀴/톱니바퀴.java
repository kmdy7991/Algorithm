import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int n;
	static char[][] gear;
	static int[] dir;
	static int[] point = { 1, 2, 4, 8 };

	public static void main(String[] args) throws IOException {
		sol();
	}

	private static void sol() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		gear = new char[4][];
		for (int i = 0; i < 4; i++) {
			gear[i] = in.readLine().toCharArray();
		}
		n = stoi.apply(in.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int num = stoi.apply(st.nextToken())-1;
			int d = stoi.apply(st.nextToken());
			dir = new int[4];
			dir[num] = d;
			wheel(num, d);

		}

		int res = 0;
		for (int i = 0; i < 4; i++) {
			if(gear[i][0] == '1') {
				res += point[i];
			}
		}
		
		out.write(res + "");
		out.close();
	}

	private static void wheel(int num, int d) {
		for(int i = num + 1; i < 4; i++) {
			if(gear[i][6] != gear[i-1][2]) {
				dir[i] = -dir[i-1];
			}
			else {
				break;
			}
		}
		
		for(int i = num - 1; i >= 0; i--) {
			if(gear[i][2] != gear[i+1][6]) {
				dir[i] = -dir[i+1];
			}
			else {
				break;
			}
		}
		rotate();
	}

	private static void rotate() {
		for(int i = 0; i < 4; i++) {
			if(dir[i] == -1) {
				char tmp = gear[i][0];
				for(int j = 0; j < 7; j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = tmp;
			}
			
			else if(dir[i] == 1) {
				char tmp = gear[i][7];
				for(int j = 7; j > 0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = tmp;
			}
		}
	}

}