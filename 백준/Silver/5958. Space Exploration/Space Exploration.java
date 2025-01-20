import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi.apply(in.readLine());

        char[][] map = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        System.out.print(findStar(map, n));
    }

    private static int findStar(char[][] map, int n) {
        boolean[][] visited = new boolean[n][n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*' && !visited[i][j]) {
                    visitStar(i, j, map, visited);

                    res++;
                }
            }
        }
        
        return res;
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<int[]> q = new ArrayDeque<>();

    private static void visitStar(int r, int c, char[][] map, boolean[][] visited) {
        visited[r][c] = true;
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dx[i];
                int nc = cur[1] + dy[i];
            
                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || visited[nr][nc]) {
                    continue;
                }

                if (map[nr][nc] == '*') {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}