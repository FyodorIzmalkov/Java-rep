class A{
    int i,j;

    A(int a, int b){
        i = a;
        j = b;
    }

    void Show(){
        System.out.println("i and j: " + i + " " + j); 
    }
}

class B extends A{
    int k;
    B(int a, int b, int c){
        super(a,b);
        k = c;
    }

    void Show(){
        super.Show();
        System.out.println("k is: " + k); 
    }
}

class Override{
    public static void main(String args[]){
        B ob = new B(10,15,20);
        ob.Show();
    }
}