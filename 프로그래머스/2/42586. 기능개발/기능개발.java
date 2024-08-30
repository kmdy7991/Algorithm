import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        List<Integer> deploy = new ArrayList<>();
        
        int day = date(progresses[0], speeds[0]);
        stack.offerLast(progresses[0]);
        
        for(int i = 1; i < progresses.length; i++) {
            if (date(progresses[i], speeds[i]) <= day) {
                stack.offerLast(progresses[i]);
            } else {
                day = date(progresses[i], speeds[i]);
                deploy.add(stack.size());
                stack.clear();
                stack.offerLast(progresses[i]);
            }
        }
        
        if(!stack.isEmpty()){
            deploy.add(stack.size());
        }
        
        int[] res = new int[deploy.size()];
        
        for(int i = 0; i <  deploy.size();i++){
            res[i] = deploy.get(i);
        }
        
        return res;
    }
    
    private static int date(int progress, int speed) {
        return (int) Math.ceil((100 - progress) / (double) speed);
    }
}