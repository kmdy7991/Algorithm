import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t1 = stoi.apply(in.readLine());
        int t2 = stoi.apply(in.readLine());
        int t3 = stoi.apply(in.readLine());

        boolean triangle = t1 + t2 + t3 == 180;

        String res = "Error";
        if (triangle) {
            if (t1 == t2 && t3 == t1 && t1 == 60) {
                res = "Equilateral";
            } else if (t1 == t2 || t1 == t3 || t2 == t3) {
                res = "Isosceles";
            } else {
                res = "Scalene";
            }
        }
        System.out.print(res);
    }
}