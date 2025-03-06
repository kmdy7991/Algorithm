import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        boolean[] flag = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            if (!flag[i]) {
                construct(i, flag);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            if (!flag[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void construct(int num, boolean[] flag) {
        int temp = num;

        while ((temp = calc(temp)) <= 10000) {
            flag[temp] = true;
        }
    }

    private static int calc(int num) {
        int temp = num;

        while (num > 0) {
            temp += num % 10;
            num /= 10;
        }
        return temp;
    }
}
