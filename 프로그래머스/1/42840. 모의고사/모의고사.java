import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] result = new int[3];
        
        int[][] solve = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for (int i = 0; i < answers.length; i++) {
            
            if (answers[i] == solve[0][i % solve[0].length]){
                result[0]++;
            }
            
            if (answers[i] == solve[1][i  % solve[1].length]){
                result[1]++;
            }
            
            if (answers[i] == solve[2][i  % solve[2].length]) {
                result[2]++;
            }
            
        }
        
        int maxSolve = Math.max(result[0], Math.max(result[1], result[2]));
        
        List<Integer> temp = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (result[i] == maxSolve){
                temp.add(i + 1);
            }
        }
        
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}