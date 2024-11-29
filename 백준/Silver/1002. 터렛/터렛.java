import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int t = stoi.apply(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(t--> 0) {
			st = new StringTokenizer(in.readLine());
			
			int x1 = stoi.apply(st.nextToken());
			int y1 = stoi.apply(st.nextToken());
			int r1 = stoi.apply(st.nextToken());
			int x2 = stoi.apply(st.nextToken());
			int y2 = stoi.apply(st.nextToken());
			int r2 = stoi.apply(st.nextToken());
			
			double dis = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			
			int plusDis = r1 + r2;
			int subDis = Math.abs(r1 - r2);
			
			if(r1 == r2 && dis == 0) {
				sb.append(-1);
			} else if(dis < plusDis && subDis < dis) {
				sb.append(2);
			} else if(dis == plusDis || dis == subDis) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}