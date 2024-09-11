import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;

		double cnt = 0;

		double res = 0;

		while ((line = in.readLine()) != null) {
			String[] lines = line.split(" ");

			if (lines[2].equals("P")) {
				continue;
			}
			
			res += Double.parseDouble(lines[1]) * point(lines[2]);
			cnt += Double.parseDouble(lines[1]);
		}

		System.out.println(res / cnt);
	}

	private static double point(String grade) {
		switch (grade) {
		case "A+":
			return 4.5;
		case "A0":
			return 4.0;
		case "B+":
			return 3.5;
		case "B0":
			return 3.0;
		case "C+":
			return 2.5;
		case "C0":
			return 2.0;
		case "D+":
			return 1.5;
		case "D0":
			return 1.0;
		}
		return 0;
	}
}