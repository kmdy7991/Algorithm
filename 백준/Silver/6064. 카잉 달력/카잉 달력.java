import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int t = Integer.parseInt(in.readLine());


        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(in.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            System.out.println(cal(n, m, x, y));
        }
    }

    private static int cal(int n, int m, int x, int y) {
        int res = x;
        
        while(res <= n * m) {
            if((res - x) % n == 0 && (res - y) % m == 0) {
                return res;
            }
            res += n;
        }

        return -1;
    }
}