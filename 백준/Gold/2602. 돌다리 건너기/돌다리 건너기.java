import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int[][][] dp;
    static String magic;
    static String[] stone;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        magic = in.readLine();
        stone = new String[]{in.readLine(), in.readLine()};

        dp = new int[magic.length()][2][stone[0].length() + 1];

        for (int i = 0; i < magic.length(); i++) {

            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int res = cross(0, 0, 0);
        res += cross(0, 1, 0);

        System.out.print(res);
    }

    private static int cross(int idx, int turn, int curStone) {
        if (idx == magic.length()) {
            return 1;
        }
        
        if (dp[idx][turn][curStone] != -1) {
            return dp[idx][turn][curStone];
        }

        int cnt = 0;
        if (turn == 0) {
            
            for (int i = curStone; i < stone[0].length(); i++) {
                
                if (stone[0].charAt(i) == magic.charAt(idx)) {
                    cnt += cross(idx + 1, 1, i + 1);
                }
            }
        } else {
            
            for (int i = curStone; i < stone[1].length(); i++) {
                
                if (stone[1].charAt(i) == magic.charAt(idx)) {
                    cnt += cross(idx + 1, 0, i + 1);
                }
            }
        }

        return dp[idx][turn][curStone] = cnt;
    }
}