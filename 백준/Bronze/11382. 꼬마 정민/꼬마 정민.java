import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        System.out.print(Long.parseLong(st.nextToken()) + 
                         Long.parseLong(st.nextToken()) + 
                         Long.parseLong(st.nextToken())
                        );
    }
}