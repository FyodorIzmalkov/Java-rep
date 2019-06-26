public interface Store<T> extends Iterable<T> {

    void add(T value);

    T get(int index);

    int size();

    T remove(int index);
}
