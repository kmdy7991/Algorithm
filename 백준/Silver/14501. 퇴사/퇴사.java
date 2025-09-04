import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(in.readLine());

        int[][] consultant = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());

            consultant[i][0] = Integer.parseInt(st.nextToken());
            consultant[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n + 1];
        
        for(int i = n - 1; i >= 0; i--){
            result[i] = i + consultant[i][0] > n ? result[i + 1] : Math.max(result[i + 1], result[i + consultant[i][0]] + consultant[i][1]);
        }

        System.out.print(result[0]);
    }
}