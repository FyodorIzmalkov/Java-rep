public class Guess{
    public static void main(String args[])
        throws java.io.IOException{
            char ch, answer = 'K';

            System.out.println("Between A and Z");
            System.out.print("Can you guess it?");
            ch = (char)System.in.read();
            if(ch == answer) System.out.println("\n**Right**");
            else System.out.println("\nSorry, you are wrong!");
        }
}