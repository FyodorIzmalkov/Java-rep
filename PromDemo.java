public class PromDemo{
    public static void main(String args[]){
        byte b;
        int i;

        b = 10;
        i = b * b;
        b = 10;
        b = (byte) (b * b);
        System.out.println("I: " + i + " b: " + b);

        char ch1 = 'a';
        char ch2 = 'b';
        ch1 = (char)(ch1 + ch2);

        for (i = 0; i < 5; i++){
            System.out.println(i + " / 3 = " + i / 3);
            System.out.println(i + " / 3 = " + (double) i / 3);
            System.out.println();
        }
    }
}