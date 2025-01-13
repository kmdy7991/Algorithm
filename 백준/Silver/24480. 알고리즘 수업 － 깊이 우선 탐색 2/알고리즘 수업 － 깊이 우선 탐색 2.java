import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;
    static int[] visited;
    static List<Integer>[] graph;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());


        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int s = stoi.apply(st.nextToken());
            int e = stoi.apply(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        visited = new int[n + 1];
        visited[r] = ++cnt;
        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int cur) {
        for (int v : graph[cur]) {
            if (visited[v] == 0) {
                visited[v] = ++cnt;
                dfs(v);
            }
        }
    }
}