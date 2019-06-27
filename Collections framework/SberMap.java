import java.math.BigDecimal;

public class SberMap <K, V>{
    public static final int DEFAULT_SIZE = 16;

    private SberStore[] store;
    private int size;

    public SberMap(){
        this.store = new SberStore[DEFAULT_SIZE];
    }

    private class SberStore<K, V>{
        private Node head;

        private class Node{
            K key;
            V value;

            Node next;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        public void add(K key, V value){
            if (head == null) head = new Node(key, value);
            else{
                Node previous = null;
                Node curent = head;

                while (curent != null){
                    if (curent.key.equals(key)){
                        curent.value = value;
                        return;
                    }
                    previous = curent;
                    curent = curent.next;
                }
                previous.next = new Node(key, value);
            }
            size++;
        }

        public V get(K key){
            Node current = head;

            while (current != null){
                if (current.key.equals(key))
                    break;
                current = current.next;
            }
            return current != null ? current.value : null;
        }
    }

    public void put(K key, V value){
        int index = hash(key.hashCode());

        if (store[index] == null)
            store[index] = new SberStore();

        store[index].add(key, value);
    }

    private int hash(int hashcode){
        return (hashcode & 0x7fffffff) % store.length;
    }

    public V get(K key){
        int index = hash(key.hashCode());

        V value = null;
        if (store[index] != null)
            value = (V) store[index].get(key);
        return value;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        SberMap<Person, Account> myMap = new SberMap<>();
        Person person = new Person(30, "Michael");
        Account account = new Account(BigDecimal.TEN);

        myMap.put(person, account);

        Account account1 = myMap.get(person);
        System.out.println("Account contains: " + account1);
    }
}
