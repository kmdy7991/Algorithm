class Solution {
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                network(i, n, computers, visited);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private static void network(int row, int n, int[][] computers, boolean[] visited){
        for(int i = 0; i < n; i++){
            if(i == row){
                continue;
            }
            
            if(!visited[i] && computers[row][i] == 1){
                visited[i] = true;
                network(i, n, computers, visited);
            }
        }
    }
}