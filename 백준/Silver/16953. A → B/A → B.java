import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        String n = st.nextToken();
        String m = st.nextToken();

        System.out.println(findNum(n, m));
    }

    private static int findNum(String n, String m) {
        Queue<String> q = new ArrayDeque<>();
        q.offer(n);

        int cnt = 0;
        int res = -1;
        while (!q.isEmpty()) {
            int len = q.size();
            
            for (int i = 0; i < len; i++) {
                String cur = q.poll();

                if(Long.parseLong(cur) > (int) 1e9){
                    continue;
                }

                if (Long.parseLong(cur) == Long.parseLong(m)) {
                    q.clear();
                    res = cnt + 1;
                    break;
                }
                q.offer((Long.parseLong(cur) * 2) + "");
                q.offer(Long.parseLong(cur) + "1");
            }
            cnt++;
        }
        return res;
    }
}