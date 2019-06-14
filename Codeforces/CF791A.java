package Codeforces;

import java.io.*;
import java.util.StringTokenizer;

public class CF791A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int counter = 0;
        while (a <= b){
            a *= 3;
            b *= 2;
            counter++;
        }
        printWriter.println(counter);
        printWriter.close();
    }
}
