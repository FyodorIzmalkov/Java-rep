import java.util.ArrayList;
import java.util.List;

public class MyFourthArrayList<V> {

    private static final int DEFAULT_SIZE = 10;
    private static final int RATE = 2;
    private int size;
    Object[] store;

    public MyFourthArrayList(){
        this.store = new Object[DEFAULT_SIZE];
    }

    public MyFourthArrayList(int newSize){
        this.store = new Object[newSize];
    }

    public void add(V value){
        if (store.length == size) increase_capacity();

        store[size++] = value;
    }

    private void increase_capacity(){
        Object[] new_store = new Object[store.length * RATE];
        for (int i = 0; i < store.length; i++) {
            new_store[i] = store[i];
        }
        this.store = new_store;
    }

    public V get(int index){
        return (V) store[index];
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MyFourthArrayList<String> list = new MyFourthArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(" string " + i);
        }

        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i));
        }
        System.out.println("Size is: " + list.size);

        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            list1.add(i +1);
        }

        System.out.println(list1.stream().filter(x -> x >= 10).count());

    }
}
