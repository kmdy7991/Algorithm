import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Long> q = new PriorityQueue<>();
        
        for (long val : scoville) {
            q.offer(val);
        }
        
        int cnt = 0;
        while (!q.isEmpty()) {
            if(q.peek() >= K) {
                return cnt;
            }
            
            if (q.peek() < K && q.size() == 1) {
                return -1;
            }
            
            q.offer(q.poll() + (q.poll() << 1));
            
            cnt++;
        }
        
        return -1;
    }
}