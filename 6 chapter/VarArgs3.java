class VarArgs3{
    static void vaTest(int ... v){
        System.out.println("vaTest(int ... v): " + "Number of args: " + v.length);
        System.out.println("Contents: ");

        for (int i = 0; i < v.length; i++)
            System.out.println(" arg: " + i + " " + v[i]);
        System.out.println();
    }

    static void vaTest(boolean ... v){
        System.out.println("vaTest(boolean ... v): " + "Number of args: " + v.length);
        System.out.println("Contents: ");

        for (int i = 0; i < v.length; i++)
            System.out.println(" arg: " + i + " " + v[i]);
        System.out.println();
    }

    static void vaTest(String ... v){
        System.out.println("vaTest(String ... v): " + "Number of args: " + v.length);
        System.out.println("Contents: ");

        for (int i = 0; i < v.length; i++)
            System.out.println(" arg: " + i + " " + v[i]);
        System.out.println();
    }

    public static void main(String args[]){
        vaTest(1,2,3,4,5,6,7);
        vaTest(true, false, true, true, false);
        vaTest("One", "Two", "Three");
    }
}