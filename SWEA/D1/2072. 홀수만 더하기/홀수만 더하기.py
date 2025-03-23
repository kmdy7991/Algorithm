import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        
		for (int tc = 1; tc <= n; tc++) {
            int sum = 0;
            
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
            
                if (num % 2 != 0) {
                    sum+= num;
                }
            }
            
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
        
        System.out.print(sb);
	}
}