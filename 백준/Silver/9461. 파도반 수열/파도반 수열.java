import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long[] triangle = new long[101];
        triangle[0] = 1L;
        triangle[1] = 1L;
        triangle[2] = 1L;

        for (int i = 3; i < 101; i++) {
            triangle[i] = triangle[i - 2] + triangle[i - 3];
        }

        int t = stoi.apply(in.readLine());
        while (t-- > 0) {
            int n = stoi.apply(in.readLine());
            System.out.println(triangle[n - 1]);
        }
    }
}