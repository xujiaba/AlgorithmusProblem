

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    /**
     * use thread itself as  synchronization state
     * 使用Owner Thread作为同步状态，比使用一个简单的boolean flag可以携带更多信息
     * <p>
     * *  ABA问题解决方案：
     * * 1. 加版本号   1A - 2B -  3A
     * * 2. 对java而言，jdk1.5提供了AtomicStampedReference来解决这个问题
     */
    private AtomicReference<Thread> owner = new AtomicReference<>();
    /**
     * reentrant count of a thread, no need to be volatile
     */
    private int count = 0;

    public void lock() {
        Thread t = Thread.currentThread();
        // if re-enter, increment the count.
        if (t == owner.get()) {
            ++count;
            return;
        }
        //spin
        while (owner.compareAndSet(null, t)) {  //CAS
        }
    }

    public void unlock() {
        Thread t = Thread.currentThread();
        //only the owner could do unlock;
        if (t == owner.get()) {
            if (count > 0) {
                // reentrant count not zero, just decrease the counter.
                --count;
            } else {
                // compareAndSet is not need here, already checked
                owner.set(null);
            }
        }
    }
}