import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        if (triangle.length == 1) {
            return triangle[0][0];
        }
        
        cal(triangle.length, triangle);
        
        return triangle[0][0];
    }
    
    
    private void cal(int n, int[][] tri) {
        
        for (int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                tri[i][j] = Math.max(
                    tri[i][j] + tri[i + 1][j],
                    tri[i][j] + tri[i + 1][j + 1]
                );
            }
        }
    }
}