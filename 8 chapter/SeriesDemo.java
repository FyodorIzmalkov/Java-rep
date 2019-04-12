class ByTwos implements Series{
    int start;
    int val;
    int prev;

    ByTwos(){
        start = 0;
        val = 0;
        prev = -2;
    }

    public int getNext(){
        prev = val;
        val += 2;
        return val;
    }

    public void reset(){
        val = start;
        prev = start - 2;
    }

    public void setStart(int x){
        start = x;
        val = x;
        prev = x - 2;
    }

    int getPrevious(){
        return prev;
    }
}

class ByThrees implements Series{
    int start;
    int val;

    ByThrees(){
        start = 0;
        val = 0;
    }

    public int getNext(){
        val += 3;
        return val;
    }

    public void reset(){
        val = start;
    }

    public void setStart(int x){
        start = x;
        val = x;
    }
}

class SeriesDemo{
    public static void main(String args[]){
        ByTwos ob = new ByTwos();
        ByThrees ob1 = new ByThrees();

        for (int i = 0; i < 5; i++)
            System.out.println("Next value is: " + ob.getNext());
        
        System.out.println("\nReseting!");
        ob.reset();

        for (int i = 0; i < 5; i++)
            System.out.println("Next value is: " + ob.getNext());

        ob.setStart(100);
        System.out.println("Starting at 100: ");

        for (int i = 0; i < 5; i++)
            System.out.println("Next value is: " + ob.getNext());
        
        for (int i = 0; i < 5; i++)
            System.out.println("ByThrees: " + ob1.getNext());
    }
}