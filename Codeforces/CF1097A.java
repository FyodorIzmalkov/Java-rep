package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF1097A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = br.readLine().split(" ");
        for (String s: arr){
            if (str.charAt(0) == s.charAt(0) || str.charAt(1) == s.charAt(1)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
