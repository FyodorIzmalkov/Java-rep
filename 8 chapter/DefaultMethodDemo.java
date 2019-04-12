class MyIFImp implements MyIF{
    public int getUserID(){
        return 100;
    }
}

class MyIFImp2 implements MyIF{
    public int getUserID(){
        return 200;
    }

    public int getAdminID(){
        return 17;
    }
}

class DefaultMethodDemo{
    public static void main(String args[]){
        MyIFImp obj = new MyIFImp();

        System.out.println("User id is: " + obj.getUserID());
        System.out.println("Admin id is: " + obj.getAdminID());
        MyIFImp2 obj2 = new MyIFImp2();
        System.out.println("Second admin id: " + obj2.getAdminID());

        System.out.println("unid: " + MyIF.getUniversalID());
    }
}