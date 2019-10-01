package ByteDance;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage2 {
    private final int MAX_SIZE = 100;
    private LinkedList<Object> list = new LinkedList<Object>();

    private final Lock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    public void produce(String producer) {
        lock.lock();
        while (list.size() == MAX_SIZE) {
            System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务！");
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(new Object());
        System.out.println("【" + producer + "】: 生产了一个产品\t 【现仓储量为】：" + list.size());
        empty.signalAll();
        lock.unlock();
    }

    public void consume(String consumer) {
        lock.lock();
        while (list.size() == 0) {
            System.out.println("仓库已空，【" + consumer + "】：暂时不能执行消费任务！");
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove();
        System.out.println("【" + consumer + "】： 消费了一个产品\t【现仓储量为】： " + list.size());
        full.signalAll();
        lock.unlock();
    }
}

