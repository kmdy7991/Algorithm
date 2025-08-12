import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        
        for (int[] cut : commands ) {
            int[] tmp = Arrays.copyOfRange(array, cut[0] - 1, cut[1]);
            Arrays.sort(tmp);
            result.add(tmp[cut[2] - 1]);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}