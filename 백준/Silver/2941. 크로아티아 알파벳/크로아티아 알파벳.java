import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String word = in.readLine();

        String[] match = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String m : match) {
            word = word.replaceAll(m, "*");
        }

        System.out.print(word.length());
    }
}