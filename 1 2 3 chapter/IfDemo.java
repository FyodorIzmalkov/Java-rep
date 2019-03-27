public class IfDemo{
    public static void main(String args[]){
        int a,b,c;

        a = 2;
        b = 3;
        if (a<b) System.out.println("a is less then b");
        System.out.println();
        c = a - b;
        System.out.println("C conctains -1");
        if (c < 0) System.out.println("C is negative");
        System.out.println();
        c = b - a;
        System.out.println("C contains 1");
        if (c >= 0) System.out.println("C is non-negative");
    }
}