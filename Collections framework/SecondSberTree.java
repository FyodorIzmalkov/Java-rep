public class SecondSberTree <K extends Comparable, V>{
    private Node root;
    private int size;

    private class Node{
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value){
        Node node = new Node(key, value);
        root = put(root, node);
    }

    private Node put(Node current, Node node){
        if (current == null) return node;

        int diff = current.key.compareTo(node.key);
        if (diff < 0) current.right = put(current.right, node);
        else if (diff > 0) current.left = put(current.left, node);
        else current.value = node.value;

        return current;
    }

    public V get(K key){
        Node node = get(root, key);

        return node != null ? node.value : null;
    }

    public Node get(Node current, K key){
        if (current == null) return null;

        int diff = current.key.compareTo(key);
        if (diff < 0) return get(current.right, key);
        else if (diff > 0) return get(current.left, key);
        else return current;
    }

    public void ascending(){
        System.out.println("Ascending: ");
        ascending(root);
        System.out.println();
    }

    private void ascending(Node current){
        if (current == null) return;

        ascending(current.left);
        System.out.print(current.value + ", ");
        ascending(current.right);

    }

    public void descending(){
        System.out.println("Descending: ");
        descending(root);
        System.out.println();
    }

    private void descending(Node current){
        if (current == null) return;

        descending(current.right);
        System.out.print(current.value + ", ");
        descending(current.left);
    }

    public static void main(String[] args) {
        SecondSberTree<Integer, String> secondSberTree = new SecondSberTree<>();

        for (int i = 1; i < 20; i++) {
            secondSberTree.put( i, "Str" + i);
        }

        secondSberTree.descending();
        secondSberTree.ascending();
    }
}
