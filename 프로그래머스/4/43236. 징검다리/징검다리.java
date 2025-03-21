import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = -1;
        
        Arrays.sort(rocks);
        
        int[] arr = new int[rocks.length + 1];
        for(int i = 0; i < rocks.length; i++){
            arr[i] = rocks[i];
        }
        
        arr[rocks.length] = distance;
        // System.out.println(Arrays.toString(arr));
        
        int s = 1;
        int e = distance;
        
        while(s <= e) {
            int mid = (s + e) / 2;
            
            int cnt = 0;
            int prev = 0;
            // int min = distance;
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] - prev < mid) {
                    cnt++;
                } else {
                    // min = Math.min(min, arr[i] - prev);
                    prev = arr[i];
                }
            }
            
            if (cnt <= n) {
                // answer = Math.max(answer, min);
                answer = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        return answer;
    }
}