import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            if (!stack.isEmpty() && stack.peekLast() == s.charAt(i)) {
                stack.pollLast();
                continue;
            }
            
            stack.offerLast(s.charAt(i));
        }
        
        if(stack.isEmpty()){
            return 1;
        }
        
        return 0;
    }
}