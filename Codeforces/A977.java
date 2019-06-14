package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int k = Integer.parseInt(strArr[1]);
//        while (k != 0){
//            if (n % 10 == 0) {
//                n /= 10;
//                k--;
//            }
//            else
//            {
//                int t = n % 10;
//                if (k >= t) {
//                    n -= t;
//                    k -= t;
//                }
//                else{
//                    n -= k;
//                    k = 0;
//                }
//
//            }
//        }
        while (k!= 0){
            if (n % 10 == 0)
                n /= 10;
            else
                --n;
            k--;
        }
        System.out.println(n);
    }
}
