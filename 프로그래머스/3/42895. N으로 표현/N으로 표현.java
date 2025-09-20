import java.util.*;

class Solution {
    static List<Set<Integer>> dp;
    
    public int solution(int N, int number) {
        int answer = 0;
        
        dp = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        if (N == number) {
            return 1;
        }
        
        return presentN(dp, N, number);
    }
    
    private int presentN(List<Set<Integer>> dp, int N, int number) {
        for (int i = 2; i < 9; i++) {
            int n = Integer.parseInt((N + "").repeat(i));
            
            for (int j = 1; j <= i / 2; j++) {
                cal(dp.get(i), dp.get(j), dp.get(i - j));
                cal(dp.get(i), dp.get(i - j), dp.get(j));
            }
            
            dp.get(i).add(n);
            
            for (int num : dp.get(i)) {
                if (number == num) {
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    private void cal(Set<Integer> dp, Set<Integer> c1, Set<Integer> c2) {
        for (int i : c1) {
            for (int j : c2) {
                dp.add(i + j);
                dp.add(i - j);
                dp.add(i * j);
                if (j != 0) {
                    dp.add(i / j);
                }
            }
        }
    }
}