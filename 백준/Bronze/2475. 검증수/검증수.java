import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        List<Long> nums = new ArrayList<>();

        while (st.hasMoreTokens()) {
            nums.add((long) Math.pow(Long.parseLong(st.nextToken()), 2));
        }
        
        System.out.print(nums.stream().mapToLong(Long::longValue).sum() % 10);
    }
}