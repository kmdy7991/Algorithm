import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi.apply(in.readLine());


        System.out.print(fact(n));
    }

    private static int fact(int n) {
        if(n <= 1 ){
            return 1;
        }
        return n * fact(n - 1);
    }
}