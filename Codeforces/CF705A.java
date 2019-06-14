package Codeforces;

import java.io.*;

public class CF705A {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= n; i++){
            if (i % 2 != 0)
                printWriter.print("I hate ");
            else
                printWriter.print("I love ");
            if (i != n)
                printWriter.print("that ");
            else
                printWriter.print("it");
        }
        printWriter.close();
//        String str = "I hate";
//        for (int i = 2; i <= n; i++){
//            if (i % 2 == 0)
//                str += " that I love";
//            else
//                str += " that I hate";
//        }
//        printWriter.println(str + " it");
//        printWriter.close();
    }
}
