import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }


        while (deque.size() > 1) {
            if (deque.size() > k) {
                deque.addLast(deque.removeFirst());

                for (int i = 0; i < k - 1; i++) {
                    deque.removeFirst();
                }
            } else {
                break;
            }
        }
        System.out.print(deque.removeFirst());
    }
}