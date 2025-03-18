class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int s = 0;
        int e = 0;
        int temp = 0;
        while(s < n) {
            if (temp < n) {
                temp += ++e;
            } else {
                temp -= ++s;
            }
            
            if(temp == n){
                answer++;
            }
        }
        
        return answer;
    }
}