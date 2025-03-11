import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(npe(arr, n - 1));
    }

    private static String npe(int[] arr, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int[] store = new int[n + 1];
        Arrays.fill(store, -1);

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] < arr[i]) {
                store[stack.pollLast()] = arr[i];
            }

            stack.offerLast(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : store) {
            sb.append(num).append(" ");
        }

        return sb.toString();
    }
}
