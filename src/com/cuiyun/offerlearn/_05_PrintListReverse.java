package com.cuiyun.offerlearn;

import java.util.Stack;

/**
 * 输入一个链表的头结点，从尾到头反过来打印每个节点的值
 */
public class _05_PrintListReverse {

    public static void main(String[] args) {
        ListNode<String> node3 = new ListNode<String>("3", null);
        ListNode<String> node2 = new ListNode<String>("2", node3);
        ListNode<String> head = new ListNode<String>("1", node2);
        printReverse(head); //递归方式打印
        //printReverse1(head); //利用栈结构反转打印
    }

    /**
     * 通过栈的方式打印
     * @param node
     */
    public static void printReverse1(ListNode<String> node) {
        if (node == null)
            return;
        Stack<String> stack = new Stack<String>();
        stack.push(node.getVal());
        while (node.next() != null) {
            stack.push(node.next().getVal());
            node = node.next();
        }

        while (stack.size() != 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 递归方式打印
     * @param node
     */
    public static void printReverse(ListNode<String> node) {
        if (node != null) {
            if (node.next() != null) {
                printReverse(node.next());
            }
            System.out.println(node.getVal());
        }
    }

    private static class ListNode<T> {
        private T val;
        private ListNode<T> next;

        public ListNode(T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }

        public ListNode<T> next() {
            return next;
        }

        public T getVal() {
            return val;
        }
    }
}