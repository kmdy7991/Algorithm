import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            st = new StringTokenizer(in.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int dist = e - s;
            int sqrt = (int) Math.sqrt(dist);

            int result = Math.sqrt(dist) == sqrt ? (sqrt << 1) - 1 : sqrt << 1;

            if (dist > sqrt * (sqrt + 1)) {
                result++;
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
