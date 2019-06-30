public class MySecondLinkedList<V> {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        V value;
        Node next;
        Node previous;

        public Node(V value){
            this.value = value;
        }
    }

    public void add(V value){
        if (head == null){
            head = new Node(value);
            tail = head;
        }
        else{
            Node node = new Node(value);
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public V get(int index){
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MySecondLinkedList<Integer> mySecondLinkedList = new MySecondLinkedList<>();
        for (int i = 0; i < 14; i++) {
            mySecondLinkedList.add(i);
        }

        for (int i = 0; i < mySecondLinkedList.size(); i++) {
            System.out.println(mySecondLinkedList.get(i)+ " ");
        }
    }
}
