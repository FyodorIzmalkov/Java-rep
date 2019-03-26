public class VarInitDemo{
    static public void main(String args[]){
        int x;

        for (x = 0; x < 3; x++){
            int y = -1;
            System.out.println("Y is: " + y);
            y = 100;
            System.out.println("Y now is: " + y);
        }
    }
}