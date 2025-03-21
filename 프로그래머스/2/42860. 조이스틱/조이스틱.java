class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            int max = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            answer += max;
            
            int cur = i + 1;
            while(cur < name.length() && name.charAt(cur) == 'A'){
                cur++;
            }
            
            move = Math.min(move, (i << 1) + name.length() - cur);
            move = Math.min(move, i + ((name.length() - cur) << 1));
        }
        
        
        return answer + move;
    }
}