package src.com.cuiyun.offerlearn;

import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 *          8                                 8
 *      6       10   >>>>>>>>>>>>>>>>   10         6
 *         7    9    11               11     9    7
 *
 *
 *
 */
public class _19_MirrorOfBinaryTree {

    public static void main(String[] args) {

        BinaryTreeNode<Integer> treeNode = new BinaryTreeNode<>();
        treeNode.val = 8;
        treeNode.left = new BinaryTreeNode<>();
        treeNode.left.val = 6;
        treeNode.right = new BinaryTreeNode<>();
        treeNode.right.val = 10;
//        treeNode.left.left = new BinaryTreeNode<>();
//        treeNode.left.left.val = 5;
        treeNode.left.right = new BinaryTreeNode<>();
        treeNode.left.right.val = 7;
        treeNode.right.left = new BinaryTreeNode<>();
        treeNode.right.left.val = 9;
        treeNode.right.right = new BinaryTreeNode<>();
        treeNode.right.right.val = 11;

//        mirrorRecursively(treeNode);
        mirrorRecursivelyForLoop(treeNode);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.left.val);

    }

    /**
     * 循环方式，利用栈实现
     * @param root
     */
    private static void mirrorRecursivelyForLoop(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            BinaryTreeNode<Integer> node = stack.pop();

            BinaryTreeNode<Integer> tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;

            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
    }

    /**
     * 递归方式
     * @param node
     */
    private static void mirrorRecursively(BinaryTreeNode<Integer> node) {
        if (node == null)
            return;

        BinaryTreeNode<Integer> tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;

        if (node.left != null) {
            mirrorRecursively(node.left);
        }
        if (node.right != null) {
            mirrorRecursively(node.right);
        }
    }

    private static class BinaryTreeNode<T> {
        T val;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }
}
