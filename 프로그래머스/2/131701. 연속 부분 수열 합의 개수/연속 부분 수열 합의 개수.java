import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> sum = new HashSet<>();
        
        for (int start = 1; start <= elements.length; start++) {
            int num = 0;
            
            for (int i = 0; i < start; i++) {
                num += elements[i];
            }
            
            sum.add(num);
            
            int cur = 0;
            while (cur < elements.length - 1) {
                num -= elements[cur];
                num += elements[(start + cur++) % elements.length];
                sum.add(num);
            }
        }
        return sum.size();
    }
}