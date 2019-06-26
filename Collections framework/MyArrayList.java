import java.util.Iterator;

public class MyArrayList<T> implements Store<T>{

    public static final int DEFAULT_SIZE = 10;
    public static final int RATE = 2;
    private Object[] store;
    private int size;

    public MyArrayList(){
        this.store = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int capacity){
        this.store = new Object[capacity];
    }

    @Override
    public void add(T value){
        if (store.length == size) increaseSize();

        store[size++] = value;
    }

    private void increaseSize(){
        Object[] newStore = new Object[store.length * RATE];

        for (int i = 0; i <store.length ; i++) {
            newStore[i] = store[i];
        }
        this.store = newStore;
    }

    @Override
    public T get(int index){
        return (T) store[index];
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public T remove(int index){
        Object tmp = store[index];
        store[index] = null;
        return (T) tmp;
    }

    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>(){
            private int current = 0;

            @Override
            public boolean hasNext(){
                return current < size;
            }

            @Override
            public T next(){
                return (T)store[current++];
            }
        };
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 12 ; i++) {
            list.add(i + 1);
        }

        for (Integer i : list){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("----------");

        for (int i = 0; i < list.size; i++) {
            if (i == 2)
                list.remove(i);
        }
        for (Integer i : list){
            System.out.print(i + " ");
        }
    }
}
