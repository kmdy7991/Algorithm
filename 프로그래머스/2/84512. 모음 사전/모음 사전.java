class Solution {
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    int answer = 0;
    int cnt = 0;
    
    public int solution(String word) {
        search(word, "");
        
        return answer;
    }
    
    private void search(String word, String make) {
        if (make.length() > 5) {
           return; 
        }
        
        if(word.equals(make)){
            answer = cnt;
        }
        
        cnt++;
        for (char c : alpha) {
            search(word, make + c);
        }
    }
}