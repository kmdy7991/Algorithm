class Solution {
    public int solution(int n) {
        int answer = n;
        
        int origin = Integer.bitCount(n);
        while(true) {
            
            if(origin == Integer.bitCount(++answer)) {
                break;
            }
        }
        
        return answer;
    }
}