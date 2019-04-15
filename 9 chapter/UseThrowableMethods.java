class ExcTest{
    static void genExcpetion(){
        int nums[] = new int[4];

        System.out.println("Before exception is generated.");
        nums[8] = 15;
        System.out.println("This won't be displayed.");
    }
}

class UseThrowableMethods{
    public static void main(String args[]){
        try{
            ExcTest.genExcpetion();
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("Standard message is: ");
            System.out.println(exc);
            System.out.println("\nStack trace: ");
            exc.printStackTrace();
        }
        System.out.println("After catch statement.");
    }
}