public class SqrRoot{
    public static void main(String args[]){
        double num;
        double err;
        double sqr;

        for (num = 1; num <= 100; num++){
            sqr = Math.sqrt(num);
            System.out.println("Sqrt of " + num + " is " + sqr);
            err = num - (sqr * sqr);
            System.out.println("Error is :" + err);
        }
    }
}