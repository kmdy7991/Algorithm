import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String line = in.readLine().strip();
		if (line.length() == 0) {
			System.out.print(0);
		} else {
			System.out.print(line.split(" ").length);
		}
	}
}