import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int chl, cnt = Integer.MAX_VALUE;
    static boolean[] fix = new boolean[10];
    
    public static void search(int n, String nowChl) {
    	for(int i = 0; i < 10; i++) {
    		if(!fix[i]) {
    			String nextChl = nowChl + Integer.toString(i);
    			int tmp = Math.abs(chl - Integer.parseInt(nextChl)) + nextChl.length();
    			cnt = Math.min(cnt, tmp);
    			if(n < 6) search(n+1, nextChl);
    		}
    		
    	}
    }
    
    public static void main(String[] args)throws IOException {
    	chl = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	
       	if(m > 0) {
       		st = new StringTokenizer(br.readLine());
       		for(int i = 0; i < m; i++) {
       			fix[Integer.parseInt(st.nextToken())] = true;
       		}
       	}
        
       	if(chl == 100) {System.out.println(0); return;}
        cnt = Math.abs(chl-100);
       	search(0, "");
       	
       	System.out.println(cnt);
    }
}