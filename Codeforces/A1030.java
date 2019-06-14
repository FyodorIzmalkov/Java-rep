package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1030 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        for (String str: arr){
//            if (Integer.parseInt(str) == 1) {
            if (str.equals("1")){
                System.out.println("HARD");
                System.exit(0);
            }
        }
        System.out.println("EASY");

    }
}
