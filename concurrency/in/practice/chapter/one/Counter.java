package concurrency.in.practice.chapter.one;

class Counter  implements Runnable{
    private int c = 0;

    private void increment() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c++;
    }

    private void decrement() {
        c--;
    }

    public int getValue() {
        return c;
    }

    @Override
    public void run() {
        //incrementing
        this.increment();
        System.out.println("Value for Thread After increment "
                + Thread.currentThread().getName() + " " + this.getValue());
        //decrementing
        this.decrement();
        System.out.println("Value for Thread at last "
                + Thread.currentThread().getName() + " " + this.getValue());
    }
}
