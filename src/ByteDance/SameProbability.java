package ByteDance;

public class SameProbability {
    //给一个函数，返回 0 和 1，概率为 p 和 1-p，请你实现一个函数，使得返回 0和1 概率一样
    // 思路：
    //1、执行两次给的函数，第一次返回1，第二次返回0的概率为(1-p)p
    //2、执行两次给的函数，第一次返回0，第二次返回1的概率为p(1-p)
    //3、循环执行两次函数，如果一次返回0，一次返回1则返回0或1

    public int getZeroOrOne() {
        // 略
        return 0;
    }

    public int getSameProbability() {
        while (true) {
            int i = getZeroOrOne();
            int j = getZeroOrOne();

            if (i == 1 && j == 0)
                return 1;

            if (i == 0 && j == 1)
                return 0;
        }
    }
}
