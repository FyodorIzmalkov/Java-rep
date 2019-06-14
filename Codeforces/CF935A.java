package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF935A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int counter = 0;
        int numberOfLeaders = 1;
        int k = n / 2;
        while (numberOfLeaders <= k){
            if ((n - numberOfLeaders) % numberOfLeaders == 0 && (n - numberOfLeaders != 0)) {
                counter++;
            }
            numberOfLeaders++;
        }
        System.out.println(counter);
    }
}
