package concurrency.in.practice.chapter.one;

public class UnsafeSequence implements Runnable {
    private int value;

    public int add (int val){
        return val + value;
    }

    @Override
    public void run() {
        value = add(5);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
