package concurrency.in.practice.chapter.two;

import java.util.concurrent.atomic.AtomicLong;

public class CountingFactorizer {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    //thread safe
    public void service() {
        count.incrementAndGet();
    }
}
