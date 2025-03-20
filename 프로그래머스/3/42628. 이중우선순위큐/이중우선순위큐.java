import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            
            String order = operation[0];
            int num = Integer.parseInt(operation[1]);
            
            if ("D".equals(order)) {
                if(map.size() <= 0){
                    continue;
                }
                
                if(num == -1) {
                    map.computeIfPresent(map.firstKey(), (k, v) -> (v - 1) == 0 ? null : v - 1);
                }
                
                if(num == 1) {
                    map.computeIfPresent(map.lastKey(), (k, v) -> (v - 1) == 0 ? null : v - 1);
                }
                continue;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return map.size() > 0 ? new int[] {map.lastKey(), map.firstKey()} : new int[] {0, 0};
    }
}