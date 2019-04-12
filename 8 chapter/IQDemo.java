class FixedQueue implements ICharQ{
    private char q[];
    private int putloc, getloc;

    public FixedQueue(int size){
        q = new char[size];
        putloc = getloc = 0;
    }

    public void put(char ch){
        if (putloc == q.length){
            System.out.println(" - Queue is full.");
            return;
        }
        q[putloc++] = ch;
    }

    public char get(){
        if (getloc == putloc){
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }

        return q[getloc++];
    }

    public void reset(){
        for (int i = 0; i < q.length; i++){
            q[i] = (char)0;
        }
        putloc = 0;
        getloc = 0;
    }
}

class   CircularQueue implements ICharQ{
    private char q[];
    private int putloc, getloc;

    public CircularQueue(int size){
        q = new char[size+1];
        putloc = getloc = 0;
    }

    public void put(char ch){
        if (putloc + 1 == getloc || ((putloc == q.length-1) && (getloc == 0))){
            System.out.println(" - Queue is full.");
            return ;
        }
        q[putloc++] = ch;
        if (putloc == q.length){
            putloc = 0;
        }
    }

    public char get(){
        if (getloc == putloc){
            System.out.println("  - Queue is empty.");
            return (char) 0;
        }

        char ch;

        ch = q[getloc++];
        if (getloc == q.length)
            getloc = 0;
        return ch;
    }

    public void reset(){
        for (int i = 0; i < q.length; i++){
            q[i] = (char)0;
        }
        putloc = 0;
        getloc = 0;
    }
}

class DynQueue implements ICharQ{
    private char q[];
    private int putloc, getloc;

    public DynQueue(int size){
        q = new char[size];
        putloc = getloc = 0;
    }

    public void put(char ch){
        if (putloc == q.length){
            char t[] = new char[q.length * 2];

            for (int i = 0; i < q.length; i++){
                t[i] = q[i];
            }
            q = t;
        }
        q[putloc++] = ch;
    }

    public char get(){
        if (getloc == putloc){
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }

        char ch;
        ch = q[getloc++];
        if (getloc == q.length)
            getloc = 0;
        return ch;
    }

    public void reset(){
        for (int i = 0; i < q.length; i++){
            q[i] = (char)0;
        }
        putloc = 0;
        getloc = 0;
    }
}

class IQDemo{
    public static void main(String args[]){
        FixedQueue q1 = new FixedQueue(10);
        DynQueue q2 = new DynQueue(5);
        CircularQueue q3 = new CircularQueue(10);

        ICharQ iQ;
        char ch;
        int i;

        iQ = q1;
        for (i = 0; i < 10; i++)
            iQ.put((char) ('A' + i));

        System.out.println("Content of fixed queue: ");
        for (i = 0; i < 10; i++){
            System.out.print(iQ.get());
        }

        System.out.println();
        iQ = q2;
        for (i = 0; i < 10; i++){
            iQ.put((char)('Z' - i));
        }

        System.out.println("Contents of dynamic queue: ");
        for (i = 0; i < 10; i++){
            System.out.print(iQ.get());
        }
        System.out.println();

        iQ = q3;
        for (i = 0; i < 10; i++){
            iQ.put((char)('A' + i));
        }
        System.out.println("Contents of cirular queue: ");
        for (i = 0; i < 10; i++){
            System.out.print(iQ.get());
        }

        System.out.println("\nStore and consume from circular queue.");
        for (i = 0; i < 20; i++){
            iQ.put((char) ('A' + i));
            System.out.print(iQ.get());
        }

    System.out.println("\nReseted the q3: ");
        iQ.reset();
        for (i = 0; i < 5; i++){
            System.out.print(iQ.get());
        }
    }
}