package src.com.cuiyun.offerlearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 *            8
 *          /   \
 *          6    10
 *        /\      /\
       5  7    9   11

 打印结果： 8,6,10,5,7,9,11
 */

public class _23_PrintFromTopToBottomBinaryTreeNode {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);

        List<Integer> res = printFromTopToBottomBinaryTreeNode(root);
        for (Integer index : res) {
            System.out.print(index +"\t");
        }
    }

    private static List<Integer> printFromTopToBottomBinaryTreeNode(BinaryTreeNode root) {
        if (root == null)
            throw new IllegalArgumentException("root is null");
        List<Integer> res = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.remove();
            res.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return res;
    }

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }
}
