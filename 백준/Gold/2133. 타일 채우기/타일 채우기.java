import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] square = new int[31];

        square[2] = 3;

        for (int i = 4; i <= n; i++) {
            if (i % 2 == 1) {
                continue;
            }

            square[i] = (square[i - 2] * 3) + 2;

            for (int j = 4; j <= i; j += 2) {
                square[i] += square[i - j] * 2;
            }
        }

        System.out.print(square[n]);
    }
}
