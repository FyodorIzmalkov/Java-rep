class VarArgs2{
    static void vaTest(String str, int ... v){
        System.out.println(str + v.length);
        System.out.println("Contents: ");

    for (int i = 0; i < v.length; i++)
        System.out.println("arg " + i + ": " + v[i]);
    System.out.println();
    }

    public static void main(String args[]){
        vaTest("ONE ARG:",1);
        vaTest("TWO ARGS:", 2, 5);
        vaTest("NO ARGS AT ALL");
    }

}