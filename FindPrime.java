public class FindPrime{
    public static void main(String args[]){
        int i;
        int num;

        for (num = 3; num <= 100; num++)
        {
            i = 2;
            while ((i <= num) && (i <= 100))
            {
                if ((num % i == 0) && num == i){
                    System.out.println("Prime number: " + num);
                    break;
                }
                else if (num % i == 0)
                    break;
                i++;
            }
        }
    }
}