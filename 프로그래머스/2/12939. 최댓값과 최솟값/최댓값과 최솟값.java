import java.util.*;

class Solution {
    public String solution(String s) {
        String[] answer = s.split(" ");
        
        int min = Integer.parseInt(answer[0]);
        int max = min;
        
        for (int i = 0; i < answer.length; i++) {
            min = Math.min(min, Integer.parseInt(answer[i]));
            max = Math.max(Integer.parseInt(answer[i]), max);
        }
        
        
        return min + " " + max;
    }
}