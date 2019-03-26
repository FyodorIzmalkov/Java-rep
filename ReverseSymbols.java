public class ReverseSymbols{
    public static void main(String args[])
        throws java.io.IOException{
            char ch;
            char next;
            int counter = 0;
            String ret = null;

            System.out.print("Type a string, '.' is an end: ");
            next = (char) System.in.read();
            while (next != '\n' && next != '.')
            {
                if (next >= 65 && next <= 90){
                 next -= 32;
                 counter++;
                 ret += next;
                }
                else if (next >= 97 && next <= 122){
                    next -=32;
                    counter++;
                    ret += next;
                }
                next = (char) System.in.read();
            }
            System.out.println(ret);
            System.out.println("Total changes: " + counter);
    }
}