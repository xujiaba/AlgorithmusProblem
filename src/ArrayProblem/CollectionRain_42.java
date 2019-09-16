package ArrayProblem;

import java.util.Stack;

public class CollectionRain_42 {
    //接雨水 LeetCode 42
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    //https://leetcode-cn.com/problems/trapping-rain-water/


    // 利用辅助栈进行解决
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int cur = 0;
        while (cur < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.pop()];    //取出要出栈的元素
                if (stack.isEmpty()) {          // 栈空就出去
                    break;
                }
                int distance = cur - stack.peek() - 1;    //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[cur]);
                sum += distance * (min - h);
            }
            stack.push(cur);//当前指向的墙入栈
            cur++;//指针后移
        }
        return sum;
    }


}
