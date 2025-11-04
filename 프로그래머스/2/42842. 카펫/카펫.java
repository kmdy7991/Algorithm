import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for (int w = total - 1; w > 0; w--) {
            int h = total / w;
            
            int y = (w - 2) * (h - 2);
            
            if (brown == (total - y) && y == yellow) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        
        return answer;
    }
}