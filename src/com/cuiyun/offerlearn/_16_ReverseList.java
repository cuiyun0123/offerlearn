package src.com.cuiyun.offerlearn;

/**
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class _16_ReverseList {

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


        ListNode<Integer> reverseHead = reverseList(node1);
        print(reverseHead);

    }

    private static void print(ListNode<Integer> head) {

        while (head != null) {
            System.out.print(head.val);

            head = head.next;
        }
    }

    private static ListNode<Integer> reverseList(ListNode<Integer> head) {

        ListNode<Integer> reverseHead = null;
        ListNode<Integer> node = head;
        ListNode<Integer> prev = null;

        while (node != null) {
            ListNode<Integer> next = node.next;

            if (next == null)
                reverseHead = node;

            node.next = prev;
            prev = node;
            node = next;
        }

        return reverseHead;

    }

    private static class ListNode<T> {
        T val;
        ListNode<T> next;
    }

}
