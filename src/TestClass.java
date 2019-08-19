import StringProblem.StringAllPermutation;

import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
//        String str = "abca";
//        ArrayList<String> permutation = StringAllPermutation.permutation(str);
//        System.out.println(permutation.toString());
        Printer p1 = new Printer();
        Printer p2 = new Printer();
        Thread t1 =  new Thread(){
            @Override
            public void run() {
                while (true){
                    p1.print1();
                }
            }
        };
        Thread t2 =  new Thread(){
            @Override
            public void run() {
                while (true){
                    p2.print1();
                }
            }
        };

        t1.start();
        t2.start();


    }

}

class Printer {
    //Demo d = new Demo();
    /*
     * 任意对象都可以当作锁对象
     * 注意:匿名对象不可以当作锁对象,因为不能保证两个锁对象是同一个对象
     * 非静态的同步方法,锁对象是this
     * 静态的同步方法,锁对象是当前类的字节码对象
     */
    public  synchronized void print1() {
            System.out.print("中");
            System.out.print("国");
            System.out.print("科");
            System.out.print("学");
            System.out.print("院");
            System.out.print(Thread.currentThread().getId());
            System.out.print("\r\n");

    }

    public static synchronized void print2() {
        System.out.print("信");
        System.out.print("息");
        System.out.print("工");
        System.out.print("程");
        System.out.print("研");
        System.out.print("究");
        System.out.print("所");
        System.out.print("\r\n");
    }

}
