package algorithm.easy.p225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class MyStack {
    Queue<Integer> que;

    /** Initialize your data structure here. */
    public MyStack() {
        que = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(x);
        while (!que.isEmpty()) {
            temp.add(que.poll());
        }
        que = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return que.poll();
    }

    /** Get the top element. */
    public int top() {
        return que.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.size() == 0;
    }
}
