import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static char[][] wheel;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		wheel = new char[4][];
		for (int i = 0; i < 4; i++) {
			wheel[i] = in.readLine().toCharArray();
		}

		StringTokenizer st;
		int k = stoi.apply(in.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());

			int num = stoi.apply(st.nextToken()) - 1;
			int clock = stoi.apply(st.nextToken());

			rotation(num, clock);
		}
		
		int res = 0;
		for(int i = 0; i < 4; i++) {
			if(wheel[i][0] == '1') {
				res += (1 << i);
			}
		}
		System.out.print(res);
	}

	private static void rotation(int num, int clock) {
		int[] clockwise = isPossible(num, clock);

		moveWheel(clockwise);
	}

	private static void moveWheel(int[] clockwise) {
		for (int i = 0; i < 4; i++) {
			if (clockwise[i] == 1) {
				char temp = wheel[i][7];
                
				for (int j = 7; j > 0; j--) {
					wheel[i][j] = wheel[i][j - 1];
				}
                
				wheel[i][0] = temp;
                
			} else if (clockwise[i] == -1) {
				char temp = wheel[i][0];
                
				for (int j = 0; j < 7; j++) {
					wheel[i][j] = wheel[i][j + 1];
				}
                
				wheel[i][7] = temp;
			}
		}
	}


	private static int[] isPossible(int num, int clock) {
		int[] check = new int[4];
        
		check[num] = clock;
		for (int i = num; i < 4 - 1; i++) {
			if (wheel[i][2] != wheel[i + 1][6]) {
				check[i + 1] = -check[i];
			}
		}

		for (int i = num; i > 0; i--) {
			if (wheel[i][6] != wheel[i - 1][2]) {
				check[i - 1] = -check[i];
			}
		}
		return check;
	}

}