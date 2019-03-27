public class Chapter3test{
    public static void main(String args[])
        throws java.io.IOException{
            char ch;
            char ignore;
            int counter = 0;
            for (;;){
                do{
                    System.out.print("Type a string, '.' is an end!");
                    ch = (char) System.in.read();
                    ignore = (char) System.in.read();
                    while (ignore != '\n' && ignore != '.')
                    {
                        if (ignore == ' ') counter++;
                        ignore = (char) System.in.read();
                    }
                    System.out.println("\n");
                }while (ignore != '.');
                System.out.println(counter);
            }
        }
}