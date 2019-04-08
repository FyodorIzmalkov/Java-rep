class A{
    A(){
        System.out.println("Constructing a!");
    }
}

class B extends A{
    B(){
        super();
        System.out.println("Construcring b!");
    }
}

class C extends B{
    C(){
        super();
        System.out.println("Constructing c!");
    }
}

class OrderOfConstruction{
    public static void main (String args[]){
        C c = new C();
    }
}