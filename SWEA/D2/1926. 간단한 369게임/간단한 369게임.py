import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = stoi.apply(in.readLine());
		
		System.out.print(
            IntStream
				.rangeClosed(1, n)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" "))
				.replaceAll("[0124578]*[369][0124578]*", "-")
		);
    }
}