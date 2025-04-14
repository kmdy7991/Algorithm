import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        nums = new int[n];
        perm(0, arr, new boolean[n]);
        System.out.print(sb);
    }

    private static void perm(int idx, int[] arr, boolean[] visited) {
        if (idx == arr.length) {
            for (int num : nums) {
                sb.append(num).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            nums[idx] = arr[i];
            perm(idx + 1, arr, visited);
            visited[i] = false;
        }
    }
}
