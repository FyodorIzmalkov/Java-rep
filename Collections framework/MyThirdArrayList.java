public class MyThirdArrayList<V> {

    private static final int DEFAULT_SIZE = 10;
    private static final int RATE = 2;
    private Object[] store;
    private int size;

    public MyThirdArrayList(){
        this.store = new Object[DEFAULT_SIZE];
    }

    public MyThirdArrayList(int store_size){
        this.store = new Object[store_size];
    }

    public void add(V value){
        if (this.store.length == size) resize();

        store[size++] = value;
    }

    private void resize(){
        Object[] newStore = new Object[RATE * store.length];
        for (int i = 0; i < store.length; i++) {
            newStore[i] = store[i];
        }
        this.store = newStore;
    }

    public V get(int index){
        return (V) store[index];
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        MyThirdArrayList<String> myThirdArrayList = new MyThirdArrayList<>();
        for (int i = 0; i < 15; i++) {
            myThirdArrayList.add("str " + i);
        }

        for (int i = 0; i < myThirdArrayList.getSize(); i++) {
            System.out.println(myThirdArrayList.get(i));
        }
    }
}
