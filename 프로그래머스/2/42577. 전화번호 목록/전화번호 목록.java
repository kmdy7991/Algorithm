import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();
        
        int n = phone_book.length;
        for(int i = 0; i < n; i++){
            map.put(phone_book[i], 0);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}