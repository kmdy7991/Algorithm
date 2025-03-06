import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(in.readLine());

        String[] names = new String[n];
        int[][] ages = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            ages[i][0] = Integer.parseInt(st.nextToken());
            ages[i][1] = i;

            names[i] = st.nextToken();
        }

        Arrays.sort(ages, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ages[i][0]).append(" ").append(names[ages[i][1]]).append("\n");
        }

        System.out.print(sb);
    }
}