import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        Set<String> words = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(String::compareTo));

        for(int i = 0; i < n; i++) {
            words.add(in.readLine());
        }

        words.forEach(System.out::println);
    }
}