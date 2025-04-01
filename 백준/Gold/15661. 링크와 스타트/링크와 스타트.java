import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(in.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(in.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeTeam(0, 0, n, new boolean[n]);
        System.out.print(res);
    }

    private static void makeTeam(int cur, int cnt, int n, boolean[] check) {
        if (cnt > n / 2) {
            return;
        }

        if (cnt > 0) {
            int team1 = 0;
            int team2 = 0;

            for (int i = 0; i < n -1 ; i++) {
                for (int j = i + 1; j < n; j++) {

                    if (check[i] && check[j]) {
                        team1 += arr[i][j] + arr[j][i];
                    }
                    
                    if (!check[i] && !check[j]) {
                        team2 += arr[i][j] + arr[j][i];
                    }
                }
            }

            res = Math.min(res, Math.abs(team1 - team2));
        }

        for (int i = cur; i < n; i++) {
            check[i] = true;
            makeTeam(i + 1, cnt + 1, n, check);
            check[i] = false;
        }
    }
}
