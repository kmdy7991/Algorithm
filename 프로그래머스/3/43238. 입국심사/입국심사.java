import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long s = times[0];
        long e = (long) n * times[0];
        
        while(s < e) {
            long m = (s + e) >> 1;
            
            long p = n;
            
            for(int time : times){
                p -= m / (long) time;
            }
            
            if (p > 0) {
                s = m + 1; 
            } else {
                e = m;
            }
        }
        
        return s;
    }
}