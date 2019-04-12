package qpack;

public interface ICharQ{
    void put(char ch);
    char get();
    void reset();
}

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