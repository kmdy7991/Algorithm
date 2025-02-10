import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static char[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String line = in.readLine();

            alpha = new char[26];
            for (int i = 0; i < line.length(); i++) {
                alpha[line.charAt(i) - 'a']++;
            }

            anagram(line, "");
        }

        result.forEach(System.out::println);
    }

    static List<String> result = new ArrayList<>();

    private static void anagram(String line, String res) {
        if (res.length() == line.length()) {
            result.add(res);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0) {
                alpha[i]--;
                anagram(line, res + (char) (i + 'a'));
                alpha[i]++;
            }
        }
    }
}