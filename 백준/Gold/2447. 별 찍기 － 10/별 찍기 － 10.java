import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        map = new char[n][n];
        star(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j] == '\u0000' ? ' ' : map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }


    private static void star(int i, int j, int three) {
        if (three == 1) {
            map[i][j] = '*';
            return;
        }

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!(r == 1 && c == 1)) {
                    star(r * (three / 3) + i, c * (three / 3) + j, three / 3);
                }
            }
        }
    }
}
