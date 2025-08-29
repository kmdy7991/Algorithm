import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Map<String, Integer> woods = new TreeMap<>();
		
        int cnt = 0;
        
		String wood;
		while ((wood = in.readLine()) != null && wood.length() > 0) {
			woods.put(wood, woods.getOrDefault(wood, 0) + 1);
			cnt++;
		}
        
		distribute(woods, cnt);
	}

	private static void distribute(Map<String, Integer> woods, int cnt) {
		StringBuilder sb = new StringBuilder();

		woods.forEach((k, v) -> sb.append(k).append(" ").append(calculate(v, cnt)).append("\n"));
		
		System.out.println(sb);
	}

	private static String calculate(int value, int cnt) {
		return String.format("%.4f",  ((double) value / cnt) * 100);
	}
}