import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(in.readLine());

        IntStream.rangeClosed(1, num).forEach(System.out::println);
    }
}