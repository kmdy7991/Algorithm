import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Node {
        int s;
        int e;
        int v;

        Node(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }

    static Queue<Node> tree;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        tree = new PriorityQueue<>(Comparator.comparingInt(o -> o.v));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.add(new Node(s, e, v));
        }

        int res = 0;
        while (!tree.isEmpty()) {
            Node cur = tree.poll();

            if(union(find(cur.s), find(cur.e))) {
                res += cur.v;
            }
        }

        System.out.print(res);
    }

    private static int find(int target) {
        if (target == parents[target]) {
            return target;
        }
        return parents[target] = find(parents[target]);
    }

    private static boolean union(int parent, int child) {
        if(parents[child] == parents[parent]) {
            return false;
        }
        parents[Math.max(parent, child)] = Math.min(parent, child);

        return true;
    }
}