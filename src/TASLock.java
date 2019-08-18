import java.util.concurrent.atomic.AtomicBoolean;

public class TASLock {

    private AtomicBoolean mutex = new AtomicBoolean(false);

    public void lock() {
// getAndSet方法会设置mutex变量为true，并返回mutex之前的值
// 当mutex之前是false时才返回，表示获取锁
// getAndSet方法是原子操作，mutex原子变量的改动对所有线程可见

        while (mutex.getAndSet(true)) {
        }
    }

    public void unlock() {
        mutex.set(false);
    }

    public String toString() {
        return "TASLock";
    }

}