import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()){
            if (c == ')') {
                if(stack.isEmpty()){
                    return false;
                } else{
                    stack.pollLast();
                }
                continue;
            }
            stack.offerLast(c);
        }
        
        return !(stack.size() > 0);
    }
}