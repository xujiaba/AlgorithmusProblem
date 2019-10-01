package ByteDance;

import java.util.LinkedList;

public class Storage {
    private final int MAX_SIZE = 100;

    private LinkedList<Object> list = new LinkedList<Object>();

    public void produce(String producer) {
        synchronized (list) {
            while (list.size() == MAX_SIZE) {
                System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务！");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【" + producer + "】: 生产了一个产品\t 【现仓储量为】：" + list.size());
            list.notifyAll();
        }
    }

    public void  consume(String consumer) {
        synchronized(list){
            while (list.size() == 0){
                System.out.println("仓库已空，【" + consumer + "】：暂时不能执行消费任务！");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("【" + consumer +"】： 消费了一个产品\t【现仓储量为】： " + list.size());
            list.notifyAll();
        }
    }
}

