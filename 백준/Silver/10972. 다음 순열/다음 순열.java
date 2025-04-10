import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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

        System.out.println(nextSequence(arr, n));
    }

    private static String nextSequence(int[] arr, int n) {
        StringBuilder sb = new StringBuilder();

        int cur = n - 1;
        while (cur > 0 && arr[cur - 1] > arr[cur]) {
            cur--;
        }

        if (cur == 0) {
            return "-1";
        }

        int idx = n - 1;
        while (idx > 0 && arr[cur - 1] > arr[idx]) {
            idx--;
        }

        swap(arr, cur - 1, idx);

        idx = n - 1;
        while (cur < idx) {
            swap(arr, cur, idx);
            cur++;
            idx--;
        }

        for (int num : arr) {
            sb.append(num).append(" ");
        }
        
        return sb.toString();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}