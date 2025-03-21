import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] prime;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        prime = init();

        boolean[] len = new boolean[numbers.length()];
        make(numbers, "", len);
        
        for (int num : set) {
            if (!prime[num]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    
    private void make(String origin, String number, boolean[] visited) {
        if (number.length() >= origin.length()) {
            return;
        }
        
        for(int i = 0; i < origin.length(); i++) {
            if (visited[i]) {
               continue; 
            }
            
            visited[i] = true;
            set.add(Integer.parseInt(number + origin.charAt(i)));
            make(origin, number + origin.charAt(i), visited);
            visited[i] = false;
        }
    }
    
    
    private boolean[] init() {
        boolean[] check = new boolean[(int) 1e8 + 1];
        
        check[0] = check[1] = true;
        
        for (int i = 2; i < (int) Math.sqrt(1e7) + 1; i++) {
            for (int j = i + i; j <= (int) 1e7; j += i) {

                if(!check[j]){
                    check[j] = true;    
                }
            }
        }
        
        return check;
    }
}