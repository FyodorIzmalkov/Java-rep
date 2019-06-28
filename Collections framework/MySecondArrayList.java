public class MySecondArrayList<V> {

    public static final int DEFAULT_SIZE = 10;
    public static final int RATE = 2;
    private Object[] store;
    private int size;

    public MySecondArrayList(){
        this.store = new Object[DEFAULT_SIZE];
    }

    public MySecondArrayList(int capacity){
        this.store = new Object[capacity];
    }

    public void add(V value){
        if (store.length == size) increase_size();
        this.store[size++] = value;
    }

    private void increase_size(){
        Object[] tmp = new Object[store.length * RATE];

        for (int i = 0; i < store.length; i++) {
            tmp[i] = store[i];
        }
        this.store = tmp;
    }

    public V get(int index){
        return (V)store[index];
    }

    public static void main(String[] args) {
        MySecondArrayList<Integer> intlist = new MySecondArrayList<>();

        for (int i = 0; i < 20; i++) {
            intlist.add(i + 1);
        }

        for (int i = 0; i < intlist.size; i++) {
            System.out.print(intlist.get(i) + " ");
        }

        System.out.println("\n----------");
        MySecondArrayList<String> stringlist = new MySecondArrayList<>();

        for (int i = 0; i < 20; i++) {
            stringlist.add("this is string number " + i);
        }

        for (int i = 0; i < intlist.size; i++) {
            System.out.println(stringlist.get(i) + " ");
        }
    }
}
