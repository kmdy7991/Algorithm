import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        return path(maps);
    }
    
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    private int path(int[][] maps){
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> q = new ArrayDeque<>();
        
        visited[0][0] = true;
        q.offer(new int[] {0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == maps.length - 1 && cur[1] == maps[0].length - 1) {
                return cur[2];
            }
            
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dx[i];
                int nc = cur[1] + dy[i];
                
                if(nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length || visited[nr][nc]){
                    continue;
                }
                
                if(maps[nr][nc] == 1){
                    q.offer(new int[] {nr, nc, cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
}