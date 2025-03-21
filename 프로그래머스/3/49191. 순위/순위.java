class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n][n];
        for (int i = 0; i < results.length; i++) {
            int win = results[i][0] - 1;
            int lose = results[i][1] - 1;
            
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (graph[j][i] == 1 && graph[i][k] == 1) {

                        graph[j][k] = 1;
                        graph[k][j] = -1;
                    }
                }   
            }   
        }

        
        for (int i = 0; i < n; i++) {
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                   cnt++; 
                }
            }
            
            if (cnt > 1) {
                answer--;
            }
        }
        
        return answer + n;
    }
}