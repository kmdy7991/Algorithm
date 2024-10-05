import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int a = stoi.apply(st.nextToken());
		int b = stoi.apply(st.nextToken());
		int c = stoi.apply(st.nextToken());
		int d = stoi.apply(st.nextToken());
		
		if(a > d) {
			System.out.print(0);
			return;
		}
		
		int time = 24;
		int tired = 0;
		int work = 0;
		while(time-- > 0){
			if(tired + a > d) {
				tired -= c;

                if(tired < 0) {
					tired = 0;
				}
			} else {
				tired += a;
				work += b;
			}
		}
		System.out.println(work);
	}
}