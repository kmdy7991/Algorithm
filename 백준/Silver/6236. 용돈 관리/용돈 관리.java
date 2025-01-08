import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());

        int[] money = new int[n];


        int s = 0;
        int e = 0;

        for (int i = 0; i < n; i++) {
            money[i] = stoi.apply(in.readLine());
            s = Math.max(s, money[i]);
            e += money[i];
        }

        while (s < e) {
            int mid = (s + e) >> 1;

            int cnt = 1;
            int price = mid;
            for (int i = 0; i < n; i++) {
                if (price - money[i] < 0) {
                    price = mid - money[i];
                    cnt++;
                } else {
                    price -= money[i];
                }
            }


            if (cnt <= m) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
            System.out.println(e);
    }
}