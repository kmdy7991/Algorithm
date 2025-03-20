import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        
        return Arrays.stream(clothes)
                     .collect(groupingBy(c -> c[1], mapping(c -> c[0], counting())))
                     .values()
                     .stream()
                     .collect(reducing(1L, (x, y) -> x * (y + 1)))
                     .intValue() - 1;
    }
}