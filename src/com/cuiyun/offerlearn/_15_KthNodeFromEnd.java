package src.com.cuiyun.offerlearn;

/**
 * 题目：输入一个链表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，
 * 本题从1 开始计数，即链表的尾结点是倒数第1 个结点．
 * 例如一个链表有6 个结点，从头结点开始它们的值依次是1 、2、3、4、5 、6。
 * 这个链表的倒数第3 个结点是值为4 的结点
 */
public class _15_KthNodeFromEnd {

    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<Integer>();
        ListNode<Integer> node2 = new ListNode<Integer>();
        ListNode<Integer> node3 = new ListNode<Integer>();
        ListNode<Integer> node4 = new ListNode<Integer>();
        ListNode<Integer> node5 = new ListNode<Integer>();
        ListNode<Integer> node6 = new ListNode<Integer>();

        node1.val = 1;
        node1.next = node2;
        node2.val = 2;
        node2.next = node3;
        node3.val = 3;
        node3.next = node4;
        node4.val = 4;
        node4.next = node5;
        node5.val = 5;
        node5.next = node6;
        node6.val = 6;


        ListNode<Integer> node = findKthToTail(node1, 3);
        System.out.println(node.val);
    }

    private static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k) {
        if (head == null || k < 0)
            return null;

        ListNode<Integer> behind = head;
        for (int i = 0; i < k - 1; i ++) {
            head = head.next;
        }

        while(head.next != null) {
            head = head.next;
            behind = behind.next;
        }
        return behind;
    }

    private static class ListNode<T> {
        T val;
        ListNode<T> next;
    }
}
