class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
        
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++) {
            answer = (answer *  arr[i]) / gcd(answer, arr[i]);
        }
        
        return answer;
    }
    
    public int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }
        
        return gcd(m, n % m);
    }
}