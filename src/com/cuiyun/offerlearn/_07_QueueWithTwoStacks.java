package com.cuiyun.offerlearn;

import java.util.Stack;

/**
 * 题目：用两个栈实现队列
 *
 * 栈的特点后进先出
 * 队列特点先进先出
 */
public class _07_QueueWithTwoStacks {

    public static void main(String[] args) {

        MyQueue<String> queue = new MyQueue<String>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        System.out.println(queue.poll());
        queue.offer("d");
        System.out.println(queue.poll());
    }


    private static class MyQueue<T> {
        Stack<T> stack1 = new Stack<T>();
        Stack<T> stack2 = new Stack<T>();

        void offer(T val) {
            stack1.push(val);
        }

        T poll() {
            if (stack1.isEmpty() && stack2.isEmpty())
                throw new RuntimeException("queue is empty!");

            if (stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
