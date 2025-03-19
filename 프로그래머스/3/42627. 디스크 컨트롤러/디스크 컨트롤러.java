import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int prev = 0;
        int cnt = 0;
        int wait = 0;
        while (cnt < jobs.length) {
            while(wait < jobs.length && jobs[wait][0] <= prev) {
                q.offer(jobs[wait++]);
            }
            
            if (q.isEmpty()) {
                prev = jobs[wait][0];
            } else {
                int[] cur = q.poll();
                
                answer += cur[1] + prev - cur[0];
                prev += cur[1];
                
                cnt++;
            }
        }
        
        return answer / jobs.length;
    }
}