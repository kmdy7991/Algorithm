import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Double> stod = Double::parseDouble;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int res = 0;
        for (int i = 1; i < n; i++) {
            res = gcd(res, arr[i] - arr[i - 1]);
        }

        System.out.println(res);
    }

    private static int gcd(int n, int m) {
        if(m == 0) return n;

        return gcd(m, n % m);
    }
}