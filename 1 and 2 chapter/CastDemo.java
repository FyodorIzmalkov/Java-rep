public class CastDemo{
    public static void main(String args[]){
        double x;
        double y;
        byte b;
        int i;
        char ch;

        x = 10.0;
        y = 3.0;
        i = (int)(x / y);
        System.out.println("Int outcome of x / y: " + i);
        i = 100;
        b = (byte)i;
        System.out.println("No info lost here: " + b);
        i = 257;
        b = (byte)i;
        System.out.println("Info lost this time: " + b);
        b = 88;
        ch = (char)b;
        System.out.println("ch: " + ch);
    }
}