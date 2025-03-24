import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        int round = 1;
        int num = 1;
        
        Set<String> game = new HashSet<>();
        game.add(words[0]);
        
        char prev = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            
            if (game.contains(words[i]) || prev != words[i].charAt(0)) {
                break;
            }
            
            prev = words[i].charAt(words[i].length() - 1);
            game.add(words[i]);
            num = (num + 1) % n;
            
            if (num == 0) {
                round++;
            }
        }
        
        return game.size() == words.length ? new int[] {0, 0} : new int[] {num + 1, round};
    }
}