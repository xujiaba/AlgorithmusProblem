package ByteDance;

import java.util.concurrent.LinkedBlockingQueue;

public class Storage3 {
    private final int MAX_SIZE = 100;
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>();

    public void produce(String producer){
        if (list.size() == MAX_SIZE){
            System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务！");
        }
        try {
            list.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + producer + "】: 生产了一个产品\t 【现仓储量为】：" + list.size());
    }

    public void consume(String consumer){
        if (list.size() == 0){
            System.out.println("仓库已空，【" + consumer + "】：暂时不能执行消费任务！");
        }
        try {
            list.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + consumer +"】： 消费了一个产品\t【现仓储量为】： " + list.size());
    }
}

