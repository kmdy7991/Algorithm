import java.util.*;

class Solution {
    List<Integer>[] tree;
    List<Integer> store = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
     
        tree = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] node : edge) {
            tree[node[0]].add(node[1]);
            tree[node[1]].add(node[0]);
        }
        
        int max = minPath(n);
        for(int res : store){
            if(res == max){
                answer++;
            }
        }
        
        return answer;
    }
    
    private final int minPath(int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {1, 0});
        visited[1] = true;

        int max = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            store.add(cur[1]);
            
            for (int next : tree[cur[0]]) {
                if(visited[next]) {
                    continue;
                }
                
                visited[next] = true;
                q.offer(new int[] {next, cur[1] + 1});
                max = Math.max(max, cur[1] + 1);
            }
        }
        
        return max;
    }
}