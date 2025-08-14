import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peekLast()] > prices[i]) {
                int cur = stack.pollLast();
                
                answer[cur] = i - cur;
            }
            
            stack.offerLast(i);
        }
        
        while (!stack.isEmpty()) {
            int cur = stack.pollLast();
            
            answer[cur] = prices.length - cur - 1;
        }
        
        
        return answer;
    }
}