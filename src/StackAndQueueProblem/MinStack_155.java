package StackAndQueueProblem;

import java.util.Stack;

public class MinStack_155 {
    /**
     * LeetCode 155
     * initialize your data structure here.
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    private Stack<Integer> stackData, stackMin;

    public MinStack_155() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stackData.push(x);
        if (stackMin.empty() || x < stackMin.peek()) {
            stackMin.push(x);
        } else {
            stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        if (!stackData.empty()) {
            stackData.pop();
            stackMin.pop();
        } else {
            throw new RuntimeException("栈为空，不能执行出栈操作！");
        }
    }

    public int top() {
        if (!stackData.empty()) {
            return stackData.peek();
        }
        throw new RuntimeException("栈为空，无法执行获取栈顶元素的操作");
    }

    public int getMin() {
        if (!stackMin.empty()) {
            return stackMin.peek();
        }
        throw new RuntimeException("栈为空，此操作非法");
    }
}
