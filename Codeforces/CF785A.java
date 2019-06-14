package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF785A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = 0;
        while (num > 0){
            String str = br.readLine();
            switch (str.charAt(0)){
                case 'T':
                {
                    result += 4;
                    break;
                }
                case 'C':
                {
                    result += 6;
                    break;
                }
                case 'O':
                {
                    result += 8;
                    break;
                }
                case 'D':
                {
                    result += 12;
                    break;
                }
                case 'I':
                {
                    result += 20;
                    break;
                }
            }
            --num;
        }
        System.out.println(result);
    }
}
