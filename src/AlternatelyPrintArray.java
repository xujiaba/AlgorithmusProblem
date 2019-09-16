public class AlternatelyPrintArray {

    public static final Object lock = new Object();

    public static void main(String[] args) {


        Thread t1 = new Thread(new Runnable() {
            int[] a = new int[]{1, 3, 5, 7, 9};

            @Override
            public void run() {
                for (int i = 0; i < a.length; i++) {
                    synchronized (lock) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(a[i]+" ");
                        lock.notify();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            int[] a = new int[]{2, 4, 6, 8, 10};

            @Override
            public void run() {
                for (int i = 0; i < a.length; i++) {
                    synchronized (lock) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(a[i]+" ");
                        lock.notify();
                    }
                }
            }
        });

        t1.start();
        t2.start();

    }
}
