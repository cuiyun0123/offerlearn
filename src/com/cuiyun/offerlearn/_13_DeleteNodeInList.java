package src.com.cuiyun.offerlearn;

import java.util.List;

/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点
 */
public class _13_DeleteNodeInList {

    public static void main(String[] args) {

        ListNode<String> node1 = new ListNode<String>("1");
        ListNode<String> node2 = new ListNode<String>("2");
        ListNode<String> node3 = new ListNode<String>("3");
        ListNode<String> node4 = new ListNode<String>("4");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        print(node1);
//        ListNode<String> head = deleteNode(node1, node1); //删除头节点
         ListNode<String> head = deleteNode(node1, node2); //删除中间节点
        // ListNode<String> head = deleteNode(node1, node4); //删除尾节点
        print(head);
    }


    private static ListNode<String> deleteNode(ListNode<String> head, ListNode<String> toBeDeleted) {
        if (head == null || toBeDeleted == null)
            return null;

        if (toBeDeleted.next != null) { //删除的节点不是尾节点
            ListNode<String> next = toBeDeleted.next;
            toBeDeleted.val = next.val;
            toBeDeleted.next = next.next;
        }
        else if (head == toBeDeleted) { //头节点且链表只有一个节点
            return null;
        }
        else { //链表多个节点，且删除的是尾巴节点

            ListNode<String> node = head;
            while (node.next != toBeDeleted) {
                node = node.next;
            }
            node.next = null;
        }
        return head;
    }

    public static class ListNode<T> {
        T val;
        ListNode<T> next;

        public ListNode() {

        }

        public ListNode(T val) {
            this.val = val;
        }
    }

    private static void print(ListNode<String> node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

}
