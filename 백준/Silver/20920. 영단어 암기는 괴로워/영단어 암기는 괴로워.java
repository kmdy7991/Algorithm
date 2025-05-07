import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String word = in.readLine();

            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        
        map
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue().reversed()
                                .thenComparing(
                                        Map.Entry.comparingByKey(
                                                Comparator.comparing(String::length).reversed())
                                )
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .forEach(k-> sb.append(k.getKey()).append("\n"));

        System.out.print(sb);
    }
}