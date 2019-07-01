public class MyThirdLinkedList<V> {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        public V value;
        public Node next;
        public Node previous;

        public Node(V value){
            this.value = value;
        }
    }

    public void add(V value){
        if (head == null) {
            head = new Node(value);
            tail = head;
        }
        else{
            Node newNode = new Node(value);
            newNode.previous = tail;
            tail.next = newNode;
            this.tail = newNode;
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
        MyThirdLinkedList<String> list = new MyThirdLinkedList<>();
        for (int i = 0; i < 17; i++) {
            list.add(" str " + i);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
