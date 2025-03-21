import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[] {priorities[i], i});
        }
        
        Arrays.sort(priorities);
        
        int idx = priorities.length - 1;
        while (!q.isEmpty()) {
            if (q.peek()[0] != priorities[idx]) {
                q.offer(q.poll());
                continue;
            }

            idx--;
            answer++;
            
            if(location == q.poll()[1]){
                break;
            }
        }
        
        return answer;
    }
}