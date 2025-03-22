import java.io.*;
import java.util.*;
class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());

        String color = "proygb";
        
        StringBuilder sb = new StringBuilder();
		
        for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine());

			String origin = st.nextToken();
			String compare = st.nextToken();
			
			int o = color.indexOf(origin.charAt(0));
			int c = color.indexOf(compare.charAt(0));

            char res = 'X';
            
            int cross = (o + 3) % color.length();
            
            int left = o - 1 < 0 ? color.length() - 1 :  o - 1;
            int right  = o + 1 >= color.length() ? 0 : o + 1;
            if (o == c) {
                res = 'E';
            } else if (c == left || c == right) {
                res = 'A';
            } else if (c == cross) {
                res = 'C';
            }
            sb.append(res).append("\n");
		}
        System.out.println(sb);
	}
}