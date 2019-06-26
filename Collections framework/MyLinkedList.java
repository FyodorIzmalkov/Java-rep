import java.util.Iterator;

public class MyLinkedList<T> implements Store<T>{
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        T value;
        Node next;
        Node previous;
        Node (T value){
            this.value = value;
        }
    }

    @Override
    public void add(T value){
        if (head == null){
            head = new Node(value);
            tail = head;
        }
        else{
            Node node = new Node(value);
            node.previous = tail;
            tail.next = node;
            this.tail = node;
        }
        size++;
    }

    @Override
    public T get(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public T remove(int index){
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        Node previous = current.previous;
        previous.next = current.next;
        Node next = current.next;
        next.previous = previous;
        return current.value;
    }

    @Override
    public Iterator<T> iterator(){
        return null;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 12 ; i++) {
            list.add(i + 1);
        }

        for (int i = 0; i < list.size ; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
