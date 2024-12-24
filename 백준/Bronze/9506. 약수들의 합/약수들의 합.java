import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = stoi.apply(in.readLine())) != -1) {

            int sum = 0;
            for (int i = 1; i <= n / 2 + 1; i++) {
                if (n % i == 0) {
                    sum += i;
                    store.add(i);
                }
            }

            if (sum == n) {
                sb.append(n).append(" = ");
                for (int num : store) {
                    sb.append(num).append(" + ");
                }
                sb.setLength(sb.length() - 2);
                sb.append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.").append("\n");
            }

            store.clear();
        }
        System.out.println(sb);
    }

    static List<Integer> store = new ArrayList<>();
}