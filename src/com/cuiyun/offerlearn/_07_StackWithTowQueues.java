package com.cuiyun.offerlearn;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 题目：用两个队列实现栈
 */
public class _07_StackWithTowQueues {

    public static void main(String[] args) {

        MyStack<String> stack = new MyStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println(stack.pop());
        stack.push("d");
        System.out.println(stack.pop());

    }

    private static class MyStack<T> {
        LinkedBlockingQueue<T> queue1 = new LinkedBlockingQueue<T>();
        LinkedBlockingQueue<T> queue2 = new LinkedBlockingQueue<T>();

        void push(T val) {

            if (!queue1.isEmpty()) {
                queue1.offer(val);
            } else {
                queue2.offer(val);
            }
        }

        T pop() {
            if (queue1.isEmpty() && queue2.isEmpty())
                throw new RuntimeException("stack is empty");

            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    if (queue1.size() == 1)
                        return queue1.poll();

                    queue2.offer(queue1.poll());
                }
            }
            else {
                while(!queue2.isEmpty()) {
                    if (queue2.size() == 1)
                        return queue2.poll();

                    queue1.offer(queue2.poll());
                }
            }


            return null;
        }
    }

}
