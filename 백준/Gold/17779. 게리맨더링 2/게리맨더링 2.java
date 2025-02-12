import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int totalCount;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(in.readLine());

        arr = new int[n][n];

        totalCount = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                totalCount += (arr[i][j] = Integer.parseInt(st.nextToken()));
            }
        }

        int minPerson = Integer.MAX_VALUE;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (x + d1 + d2 >= n || y - d1 < 0 || y + d2 >= n) {
                            continue;
                        }

                        minPerson = Math.min(minPerson, partition(n, x, y, d1, d2));
                    }
                }
            }
        }

        System.out.print(minPerson);
    }

    private static int partition(int n, int x, int y, int d1, int d2) {
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i <= d1; i++) {
            // 1
            visited[x + i][y - i] = true;

            // 4
            visited[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            // 2
            visited[x + i][y + i] = true;

            // 3
            visited[x + d1 + i][y - d1 + i] = true;
        }

        return calc(n, x, y, d1, d2, visited);
    }

    private static int calc(int n, int x, int y, int d1, int d2, boolean[][] visited) {
        int[] counts = new int[5];

        // # 1
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (visited[i][j]) {
                    break;
                }

                counts[0] += arr[i][j];
            }
        }

        // # 2
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (visited[i][j]) {
                    break;
                }
                counts[1] += arr[i][j];
            }
        }

        // # 3
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (visited[i][j]) {
                    break;
                }
                counts[2] += arr[i][j];
            }
        }

        // # 4
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y + d2 - d1; j--) {
                if (visited[i][j]) {
                    break;
                }
                counts[3] += arr[i][j];
            }
        }


        counts[4] = totalCount - (counts[0] + counts[1] + counts[2] + counts[3]);

        Arrays.sort(counts);
        return counts[4] - counts[0];
    }
}