import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t =  Integer.parseInt(in.readLine());
        
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(in.readLine());
            
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            int winner = 1;

            if (a % 2 != 0 && b % 2 != 0 && c % 2 != 0) {
                winner = 2;
            }
            System.out.println(winner);
        }
    }
}