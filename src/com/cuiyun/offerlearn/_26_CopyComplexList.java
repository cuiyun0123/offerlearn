package src.com.cuiyun.offerlearn;

/**
 * 题目：请实现函数ComplexListNode clone(ComplexListNode head),复制一个复杂链表。
 * 在复杂链表中，每个结点除了有一个next 域指向下一个结点外，还有一个sibling 指向链表中的任意结点或者null。
 */
public class _26_CopyComplexList {

    public static void main(String[] args) {
        ComplexListNode<Integer> node1 = new ComplexListNode<>();
        node1.val = 1;
        ComplexListNode<Integer> node2 = new ComplexListNode<>();
        node2.val = 2;
        ComplexListNode<Integer> node3 = new ComplexListNode<>();
        node3.val = 3;

        node1.next = node2;
        node2.next = node3;
        node1.sibling = node3;

        ComplexListNode<Integer> cloneNode = clone(node1);

        System.out.println("cloneNode.val: " + cloneNode.val);
        System.out.println("cloneNode.next.val: " + cloneNode.next.val);
        System.out.println("cloneNode.sibling.val: " + cloneNode.sibling.val);
    }

    private static ComplexListNode<Integer> clone(ComplexListNode<Integer> head) {
        cloneNodes(head);
        connectSliblingNodes(head);
        return reconnectNodes(head);
    }

    private static void cloneNodes(ComplexListNode<Integer> head) {
        ComplexListNode<Integer> node = head;
        while (node != null) {
            ComplexListNode<Integer> cloneNode = new ComplexListNode<>();
            cloneNode.val = node.val;
            cloneNode.next = node.next;
            cloneNode.sibling = null;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    private static void connectSliblingNodes(ComplexListNode<Integer> head) {
        ComplexListNode<Integer> node = head;
        while (node != null) {
            ComplexListNode<Integer> cloneNode = node.next;
            if (node.sibling != null) {
                cloneNode.sibling = node.sibling.next;
            }
            node = cloneNode.next;
        }
    }

    private static ComplexListNode<Integer> reconnectNodes(ComplexListNode<Integer> head) {
        ComplexListNode<Integer> node = head;
        ComplexListNode<Integer> cloneHead = null;
        ComplexListNode<Integer> cloneNode = null;

        // A A` B B`

        if (node  != null) {
            cloneHead = cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
        }


        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }

    private static class ComplexListNode<T> {
        T val;
        ComplexListNode<T> next;
        ComplexListNode<T> sibling;
    }

}
