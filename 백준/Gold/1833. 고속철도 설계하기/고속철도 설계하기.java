import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(in.readLine());

        int[][] city = new int[n][n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());

            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (i > j && city[i][j] < 0) {
                    res -= city[i][j];
                    city[i][j] = city[j][i] = 0;
                }
            }
        }

        System.out.print(prim(n, res, city));
    }

    private static String prim(int n, int res, int[][] city) {
        boolean[] visited = new boolean[n];
        int[] prev = new int[n];
        int[] dist = new int[n];
        
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;

        int count = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int idx = 0;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }

            visited[idx] = true;
            res += min;

            if (i != 0 && min > 0) {
                count++;
                sb.append(prev[idx] + 1).append(" ").append(idx + 1).append("\n");
            }

            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] > city[idx][j]) {
                    dist[j] = city[idx][j];
                    prev[j] = idx;
                }
            }
        }

        return res + " " + count + "\n" + sb;
    }
}