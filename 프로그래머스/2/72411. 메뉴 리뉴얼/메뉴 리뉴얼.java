import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        List<String> store = new ArrayList<>();
        
        for (int num : course) {
            for(String order : orders) {
                char[] single = order.toCharArray();
                
                Arrays.sort(single);
                match(0, "", single, num);
            }
            
            if (!map.isEmpty()) {
                List<Integer> val = new ArrayList<>(map.values());

                int max = Collections.max(val);
                
                if(max > 1) {
                    map.entrySet()
                        .stream()
                        .filter(m -> m.getValue() == max)
                        .forEach(m -> store.add(m.getKey()));
                }
            }
            map.clear();
        }
        return store.stream().sorted().toArray(String[]::new);
    }
    
    
    private void match(int cur, String menu, char[] single, int max) {
        if(menu.length() == max) {
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        }
        
        if(cur >= single.length){
            return;
        }
        
        match(cur + 1, menu + single[cur], single, max);
        match(cur + 1, menu, single, max);
    }
}