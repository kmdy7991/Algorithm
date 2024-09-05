import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int n = stoi.apply(in.readLine());
        int m = stoi.apply(in.readLine());
        
        int div = m;
        while(div > 10){
            System.out.println(n * (div % 10));
            div /= 10;
        }
        
        System.out.println(n * div);
        System.out.println(n * m);
    }
}