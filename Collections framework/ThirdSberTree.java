public class ThirdSberTree<K extends Comparable, V> {
    private Node root;

    private class Node{
        K key;
        V value;
        Node right;
        Node left;

         Node(K key, V value){
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

        return node == null ? null : node.value;
    }

    private Node get(Node current, K key){
        if (current == null) return null;

        int diff = current.key.compareTo(key);
        if (diff < 0) return get(current.right, key);
        else if (diff > 0) return get(current.left, key);
        else return current;
    }

    public void print_ascending(){
        System.out.println("Print ascending: ");
        print_ascending(root);
        System.out.println();
    }

    private void print_ascending(Node current){
        if (current == null) return;

        print_ascending(current.left);
        System.out.print(current.value + ", ");
        print_ascending(current.right);
    }

    public void print_descending(){
        System.out.println("Print descending: ");
        print_descending(root);
        System.out.println();
    }

    private void print_descending(Node current){
        if (current == null) return;

        print_descending(current.right);
        System.out.print(current.value + ", ");
        print_descending(current.left);
    }

    public static void main(String[] args) {
        ThirdSberTree<Integer, String> tree = new ThirdSberTree<>();

        for (int i = 0; i < 17; i++) {
            tree.put(i, "str " + i);
        }

        for (int i = 0; i < 17; i++) {
            System.out.println(tree.get(i));
        }

        tree.print_ascending();
        tree.print_descending();
    }
}
