package ByteDance;

import java.util.LinkedList;
import java.util.Scanner;

public class PokersMove_ByteDance {

    // 扑克牌的移动
    // 我手中有一堆扑克牌， 但是观众不知道它的顺序。
    //1、第一步， 我从牌顶拿出一张牌， 放到桌子上。
    //2、第二步， 我从牌顶再拿一张牌， 放在手上牌的底部。
    //3、第三步， 重复第一步、第二步的操作， 直到我手中所有的牌都放到了桌子上。
    //最后， 观众可以看到桌子上牌的顺序是：(牌底部）1,2,3,4,5,6,7,8,9,10,11,12,13(牌顶部）
    //请问， 我刚开始拿在手里的牌的顺序是什么？
    //思路：
    //你的手里拿了13张牌，每一次往桌子上放牌的时候，还要把手牌的第一张放到手牌的最后， 那可以推理出这可以通过13次的循环来完成，每次循环执行两个动作
    //1、先将手牌最上面一张放在桌子上
    //2、再将手牌中最上面的一张放手牌的最后
    //以上的这种操作，我称他为正向操作，也就是手牌到桌子上
    //问题中是知道了桌子上的结果，需要知道初始手牌的顺序，那其实就是把上面的操作以反向形式操作一次，也就是从桌子上到手里，简称反向操作
    //做这道题的方法叫做方向操作，时间反演法:
    //正向过程:                 手                                     桌子
    //
    //                        1->2->3->4
    //                             2->3->4                            1
    //                           3->4->2                                1
    //                            4->2                                     3->1
    //                             2->4                                    3->1
    //                              4                                       2->3->1
    //                                                                       4->2->3->1
    //反向操作:              手                                               桌子
    //                      4                                                2->3->1
    //                      2->4                                             3->1
    //                     4->2                                              3->1
    //                     3->4->2                                           1
    //                     2->3->4                                            1
    //                      1->2->3->4
    //模拟回去
    //————————————————
    //版权声明：本文为CSDN博主「wwxy261」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/wwxy1995/article/details/91048373


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] str = line.split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++)
            nums[i] = Integer.parseInt(str[i]);
        sort(nums);
        reverseSort(nums);
    }

    private static void sort(int[] pokers) {
        // 正向操作过程, 将手中的牌放到桌子上
        // 第一步先创建一个链表
        LinkedList<Integer> hands = new LinkedList<>();
        for (int poker : pokers) {
            hands.add(poker);
        }
        //声明一个新的容器，在这里可以理解成桌子
        LinkedList<Integer> table = new LinkedList<>();
        for (int i = 0; i < pokers.length; i++) {
            //将手牌中的第一张放在桌子上
            table.add(hands.pollFirst());
            //假如这是最后一次循环手牌已经没有了就不需要进入这个判断了
            if (hands.size() > 0) {
                //将第一张放在牌堆的最后
                hands.addLast(hands.pollFirst());
            }
        }
//        table.forEach(System.out::print);
        for (Integer integer : table) {
            System.out.print(integer + " ");
        }
    }

    private static void reverseSort(int[] nums) {
        // 反向操作, 将桌子上的牌变到手上
        // 创建一个链表
        LinkedList<Integer> table = new LinkedList<>();
        for (int num : nums) {
            table.add(num);
        }
        //声明一个目标容器，理解成手
        LinkedList<Integer> hands = new LinkedList<>();
        for (Integer poker : table) {
            //判断手上的牌是否大于1张
            if (hands.size() > 1){
                //如果大于一张，则把手牌的最后一张放在最上面
                hands.addFirst(hands.pollLast());
            }
            //从桌子上拿一张牌放在手上
            hands.addFirst(poker);
        }
        for (Integer hand : hands) {
            System.out.print(hand + " ");;
        }
    }


}
