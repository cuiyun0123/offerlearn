package src.com.cuiyun.offerlearn;

/**
 *题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 */
public class _17_MergeSortedLists {

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

        node4.val = 4;
        node4.next = node5;
        node5.val = 5;
        node5.next = node6;
        node6.val = 6;


        ListNode<Integer> megerList = merge(node1, node4);
        print(megerList);
    }

    private static void print(ListNode<Integer> head) {

        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode<Integer> merge(ListNode<Integer> node1, ListNode<Integer> node2) {
        if (node1 == null)
            return node2;

        if (node2 == null)
            return node1;

        ListNode<Integer> megerNode = null;
        if (node1.val < node2.val) {
            megerNode = node1;
            megerNode.next = merge(node1.next, node2);
        }
        else {
            megerNode = node2;
            megerNode.next = merge(node2.next,node1);
        }
        return megerNode;
    }

    private static class ListNode<T> {
        T val;
        ListNode<T> next;
    }

}
