import java.util.ArrayList;
import java.util.LinkedList;
import java.util.SortedMap;

public class MyArrayListVsMyLnkedList {

    public static final int ITERATIONS = 1_000_000;

    // first test
    public static void addToMyArayList(){
        long before = System.currentTimeMillis();
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }

        System.out.println(System.currentTimeMillis() - before);
    }

    public static void addToMyLinkedList(){
        long before = System.currentTimeMillis();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            linkedList.add(i);
        }

        System.out.println(System.currentTimeMillis() - before);
    }

    // second test
    public static void getFromMyArrayList(){
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long before = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            list.get(i);
        }
        System.out.println(System.currentTimeMillis() - before);
    }

    public static void getFromMyLinkedList(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }
        long before = System.currentTimeMillis();

        for (int i = 0; i < 100_000; i++) {
            list.get(i);
        }
        System.out.println(System.currentTimeMillis() - before);
    }

    // third test ADD FIRST

    public static void addFirstToArrayList(){
        long before = System.currentTimeMillis();


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100_000 ; i++) {
            list.add(0, i);
        }
        System.out.println(System.currentTimeMillis() - before);
    }

    public static void addFirstToLinkedList(){
        long before = System.currentTimeMillis();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list.addFirst(i);
        }
        System.out.println(System.currentTimeMillis() - before);
    }

    //fourth test remove from middle

    public static void removeFromMiddleArrayList(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100_000 ; i++) {
            list.add(i);
        }
        long before = System.currentTimeMillis();
        while(!list.isEmpty()){
            list.remove(list.size() / 2);
        }
        System.out.println(System.currentTimeMillis() - before);
    }

    public static void removeFromMiddleLinkedList(){
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }
        long before = System.currentTimeMillis();

        while(!list.isEmpty())
            list.remove(list.size() / 2);

        System.out.println(System.currentTimeMillis() - before);
    }

    public static void main(String[] args) {
        //addToMyArayList(); // 9 10 10 10 9 on 100_000 and 33 on 1_000_000
        //addToMyLinkedList(); // 8 7 8 7 8 and 254 on 1_000_000

        //getFromMyArrayList(); // 3 2 3 on 100_000_0
        //getFromMyLinkedList(); // timeout on 1_000_000 6879 on 100_000 no more tests needed

        //addFirstToArrayList(); // timeout on 1_000_000; 791 on 100_000
        //addFirstToLinkedList(); // 201, 199 on 1_000_000

        //removeFromMiddleArrayList(); // timeout on 1_000_000; 352,355 on 100_000;
        //removeFromMiddleLinkedList();// timeout on 1_000_000; 3367, 3381 on 100_000;

    }
}
