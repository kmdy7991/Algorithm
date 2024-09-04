import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int chl, cnt = Integer.MAX_VALUE;
    static int[][] floyd;

    public static void main(String[] args) throws IOException {
    	int n = Integer.parseInt(br.readLine());
    	floyd = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			floyd[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			for(int k = 0; k < n; k++) {
    				if(floyd[j][i] == 1 && floyd[i][k] == 1) {
    					floyd[j][k] = 1;
    				}
    			}
    		}
    	}
    	
    	for(int[] f : floyd) {
    		for(int i : f) {
    			sb.append(i + " ");
    		}
    		sb.append("\n");
    	}
    	bw.write(String.valueOf(sb));
    	bw.close();
    }
}