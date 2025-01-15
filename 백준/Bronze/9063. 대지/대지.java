import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = stoi.apply(in.readLine());

        int maxX = -(int) 1e4 + 1;
        int minX = (int) 1e4 + 1;
        int maxY = -(int) 1e4 + 1;
        int minY = (int) 1e4 + 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());

            int x = stoi.apply(st.nextToken());
            int y = stoi.apply(st.nextToken());

            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
            maxY = Math.max(maxY, y);
            minY = Math.min(minY, y);
        }

        System.out.print((maxX - minX) * (maxY - minY));
    }
}