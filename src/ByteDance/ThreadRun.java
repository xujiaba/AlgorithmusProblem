package ByteDance;

import java.util.ArrayList;
import java.util.List;

public class ThreadRun {

    public static void main(String[] args) {
        try {
            process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void process() throws Exception {
        int count = 10;
        List<Thread> workers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Thread worker = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行子线程");
                }
            });
            worker.start();
            workers.add(worker);
        }
        for (int i = 0; i < count; i++) {
            workers.get(i).join();
        }
        System.out.println("执行主线程");
    }
}
