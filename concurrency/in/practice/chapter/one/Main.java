package concurrency.in.practice.chapter.one;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
//    public static void main(String[] args) {
//        UnsafeSequence unsafeSequence = new UnsafeSequence();
//        Thread t1 = new Thread(unsafeSequence);
//        Thread t2 = new Thread(unsafeSequence);
//        t1.run();
//        t2.run();
//
//        System.out.println(unsafeSequence.getValue());
//    }
}
