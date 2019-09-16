
class P {

    public static synchronized void p1() {
        System.out.print("static ");
        System.out.print("synchronized ");
        System.out.print("ceshi");
        System.out.println();

    }
    public synchronized void p2(){
        System.out.print("====1====");
        System.out.print("====2====");
        System.out.print("====3====");
        System.out.println();

    }
}


public class TestThread {

    public static void main(String[] args) {
        P p = new P();
        Thread t1 =  new Thread(){
            @Override
            public void run() {
                while (true){
                    p.p2();
                }
            }
        };
        Thread t2 =  new Thread(){
            @Override
            public void run() {
                while (true){
                    P.p1();
                }
            }
        };
        t2.start();
        t1.start();
    }


}
