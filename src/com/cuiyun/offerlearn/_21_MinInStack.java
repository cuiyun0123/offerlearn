package src.com.cuiyun.offerlearn;

import java.util.Stack;

/**
 * 题目： 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小素的min 函数。
 * 在该栈中，调用min、push 及pop的时间复杂度都是0(1)
 *
 *
 */
public class _21_MinInStack {

    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
    }


    public static class StackWithMin<T extends Comparable<T>> {
        Stack<T> dataStack; //存数据
        Stack<Integer> minStack; //最小值在数据栈里的下标

        public StackWithMin() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(T val) {
            if (val == null) {
                throw new IllegalArgumentException("param is null");
            }

            if (dataStack.isEmpty()) {
                dataStack.push(val);
                minStack.push(0);
            } else {
                T e = dataStack.get(minStack.peek());
                dataStack.push(val);
                if (e.compareTo(val) > 0) {
                    minStack.push(dataStack.size() - 1);
                }else {
                    minStack.push(minStack.peek());
                }
            }
        }

        public T pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("stack is empty");
            } else {
                minStack.pop();
                return dataStack.pop();
            }
        }

        public T min() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return dataStack.get(minStack.peek());
        }
    }
}
