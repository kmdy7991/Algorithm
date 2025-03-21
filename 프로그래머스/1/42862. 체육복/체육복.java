import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        
        boolean[] check = new boolean[31];
        
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        
        
        for (int num : lost) {
            for(int give : reserve) {
                if (!check[give] && give == num) {
                    answer++;
                    check[give] = true;
                    break;
                }
                
                if(!check[give] && !check[num] && (num - 1 == give || num + 1 == give)) {
                    check[give] = true;
                    check[num] = true;
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}