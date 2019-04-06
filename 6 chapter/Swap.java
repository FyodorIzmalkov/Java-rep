class Test{
    int a;

    Test(int i){
        a = i;
    }

    void swap(Test ob1, Test ob2)
        {
            Test tmp;
            
            tmp = new Test(0);

            tmp.a = ob1.a;
            ob1.a = ob2.a;
            ob2.a = tmp.a;
        }
}

class Swap{
    public static void main(String args[]){
        Test ob1 = new Test(10);
        Test ob2 = new Test(20);

        System.out.println("ob1: " + ob1.a);
        System.out.println("ob2: " + ob2.a);
        ob1.swap(ob1, ob2);
        System.out.println("ob1: " + ob1.a);
        System.out.println("ob2: " + ob2.a);
    }
}