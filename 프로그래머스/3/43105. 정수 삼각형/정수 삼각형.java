import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int len = triangle.length;
        if(len == 1){
            return triangle[0][0];
        }
        
        int[][] result = new int[len + 1][len + 1];
        
        result[0][1] = result[0][0] = triangle[0][0];

        for (int i = 1; i < len; i++) {
            for(int j = 1; j <= triangle[i].length; j++) {
                
                result[i][j] = Math.max(result[i - 1][j - 1], result[i - 1][j]) + triangle[i][j - 1];
                answer = Math.max(answer, result[i][j]);
            }
        }
        
        return answer;
    }
}