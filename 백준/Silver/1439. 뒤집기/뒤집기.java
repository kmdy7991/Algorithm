import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] str = in.readLine().toCharArray();

        int[] count = new int[2];

        char prev = str[0];
        count[prev - 48]++;

        for (int i = 1; i < str.length; i++) {
            if (prev != str[i]) {
                prev = str[i];
                count[prev - 48]++;
            }
        }

        System.out.println(Math.min(count[0], count[1]));
    }
}