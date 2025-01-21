import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Double> stod = Double::parseDouble;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        double a = stod.apply(st.nextToken());
        double b = stod.apply(st.nextToken());

        int r = Integer.parseInt(in.readLine());

        int samePoint = 1;
        int time = 0;

        Set<String> store = new HashSet<>();
        store.add(a +""+ b);

        while (samePoint < 2) {
            time++;

            if (a + 1 + b + 1 < r) {
                a++;
                b++;
            } else {
                a = Math.floor(a / 2);
                b = Math.floor(b / 2);
            }

            String key = a +""+ b;
            if (store.contains(key)) {
                samePoint++;
            }
            store.add(key);
        }

        System.out.print(time);
    }
}