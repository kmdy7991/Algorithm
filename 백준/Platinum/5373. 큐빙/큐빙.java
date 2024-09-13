import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static char[][][] cube;
	static char[][][] copy;
	static char[] colors;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		colors = new char[] { 'w', 'y', 'r', 'o', 'g', 'b' };

		int n = stoi.apply(in.readLine());

		sb = new StringBuilder();
		while (n-- > 0) {
			init();

			int cnt = stoi.apply(in.readLine());

			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < cnt; c++) {
				order(st.nextToken());
			}
            
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(copy[0][i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void init() {

		cube = new char[6][3][3];
		copy = new char[6][3][3];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					cube[i][j][k] = copy[i][j][k] = colors[i];
				}
			}
		}

	}

	static int[][] rotate = { { 3, 5, 2, 4, 3 }, 
                             { 2, 5, 3, 4, 2 }, 
                             { 0, 5, 1, 4, 0 },
                             { 0, 4, 1, 5, 0 },
                             { 0, 2, 1, 3, 0 }, 
                             { 0, 3, 1, 2, 0 } 
                           };

	private static void order(String line) {
		char[] direct = new char[] { 'U', 'D', 'F', 'B', 'L', 'R' };

		for (int i = 0; i < direct.length; i++) {
			if (direct[i] == line.charAt(0)) {
				rotation(i, colors[i], line.charAt(1));
			}
		}

	}

	private static void rotation(int num, char color, char clock) {
		if (clock == '-') {
			selfMove(clock, num, 3);

			for (int i = 0; i < 3; i++) {
				move(color, num);
				paste();
			}
		} else {
			selfMove(clock, num, 1);
			move(color, num);
			paste();
		}
	}

	private static void selfMove(char clock, int num, int cnt) {
		for (int c = 0; c < cnt; c++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					copy[num][j][3 - 1 - i] = cube[num][i][j];
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cube[num][i][j] = copy[num][i][j];
				}
			}
		}
	}

	private static void move(char color, int num) {
		int cnt = 1;

		switch (color) {
		case 'w':
			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][0][1] = cube[rotate[num][cnt - 1]][0][1];
			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt++ - 1]][0][2];

			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][0][1] = cube[rotate[num][cnt - 1]][0][1];
			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt++ - 1]][0][2];

			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][0][1] = cube[rotate[num][cnt - 1]][0][1];
			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt++ - 1]][0][2];

			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][0][1] = cube[rotate[num][cnt - 1]][0][1];
			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt - 1]][0][2];

			break;

		case 'y':
			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt - 1]][2][0];
			copy[rotate[num][cnt]][2][1] = cube[rotate[num][cnt - 1]][2][1];
			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt++ - 1]][2][2];

			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt - 1]][2][0];
			copy[rotate[num][cnt]][2][1] = cube[rotate[num][cnt - 1]][2][1];
			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt++ - 1]][2][2];

			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt - 1]][2][0];
			copy[rotate[num][cnt]][2][1] = cube[rotate[num][cnt - 1]][2][1];
			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt++ - 1]][2][2];

			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt - 1]][2][0];
			copy[rotate[num][cnt]][2][1] = cube[rotate[num][cnt - 1]][2][1];
			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt - 1]][2][2];

			break;

		case 'r':
			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt - 1]][2][0];
			copy[rotate[num][cnt]][1][0] = cube[rotate[num][cnt - 1]][2][1];
			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt++ - 1]][2][2];

			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][0][1] = cube[rotate[num][cnt - 1]][1][0];
			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt++ - 1]][2][0];

			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][1][2] = cube[rotate[num][cnt - 1]][0][1];
			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt++ - 1]][0][2];

			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt - 1]][0][2];
			copy[rotate[num][cnt]][2][1] = cube[rotate[num][cnt - 1]][1][2];
			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt - 1]][2][2];

			break;

		case 'o':
			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][1][0] = cube[rotate[num][cnt - 1]][0][1];
			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt++ - 1]][0][2];

			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][2][1] = cube[rotate[num][cnt - 1]][1][0];
			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt++ - 1]][2][0];

			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt - 1]][2][0];
			copy[rotate[num][cnt]][1][2] = cube[rotate[num][cnt - 1]][2][1];
			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt++ - 1]][2][2];

			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt - 1]][0][2];
			copy[rotate[num][cnt]][0][1] = cube[rotate[num][cnt - 1]][1][2];
			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt - 1]][2][2];

			break;

		case 'g':
			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][1][0] = cube[rotate[num][cnt - 1]][1][0];
			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt++ - 1]][2][0];

			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][1][0] = cube[rotate[num][cnt - 1]][1][0];
			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt++ - 1]][2][0];

			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][1][2] = cube[rotate[num][cnt - 1]][1][0];
			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt++ - 1]][2][0];

			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt - 1]][0][2];
			copy[rotate[num][cnt]][1][0] = cube[rotate[num][cnt - 1]][1][2];
			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt - 1]][2][2];

			break;

		case 'b':
			copy[rotate[num][cnt]][2][0] = cube[rotate[num][cnt - 1]][0][2];
			copy[rotate[num][cnt]][1][0] = cube[rotate[num][cnt - 1]][1][2];
			copy[rotate[num][cnt]][0][0] = cube[rotate[num][cnt++ - 1]][2][2];

			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt - 1]][0][0];
			copy[rotate[num][cnt]][1][2] = cube[rotate[num][cnt - 1]][1][0];
			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt++ - 1]][2][0];

			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt - 1]][0][2];
			copy[rotate[num][cnt]][1][2] = cube[rotate[num][cnt - 1]][1][2];
			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt++ - 1]][2][2];

			copy[rotate[num][cnt]][0][2] = cube[rotate[num][cnt - 1]][0][2];
			copy[rotate[num][cnt]][1][2] = cube[rotate[num][cnt - 1]][1][2];
			copy[rotate[num][cnt]][2][2] = cube[rotate[num][cnt - 1]][2][2];

			break;
		}
	}

	private static void paste() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					cube[i][j][k] = copy[i][j][k];
				}
			}
		}
	}
}