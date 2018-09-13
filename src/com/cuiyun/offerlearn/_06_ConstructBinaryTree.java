package com.cuiyun.offerlearn;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，
 * 重建出下图所示的二叉树并输出它的头结点。
 *
 * 前序遍历：先访问根节点，再访问左子节点，最后访问右子节点
 * 中序遍历：先访问左子节点，再访问根节点，最后访问右子节点
 * 后序遍历：先访问左子节点，再访问右子节点，最后访问根节点
 */
public class _06_ConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8}; //前序遍历结果
        int[] mid = {4,7,2,1,5,3,8,6}; //中序遍历结果
        // 普通二叉树
        //              1
        //           /     \
        //          2       3
        //         /       / \
        //        4       5   6
        //         \         /
        //          7       8

        BinaryTreeNode<Integer> node = construct(pre, mid);

        //测试
        System.out.println(node.val);
        System.out.println(node.leftNode.val);
        System.out.println(node.rightNode.val);

    }

    private static BinaryTreeNode<Integer> construct(int[] pre, int[] mid) {
        if (pre == null || pre.length == 0 || mid == null || mid.length == 0 || pre.length != mid.length)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(pre[0]); //前序遍历第一个数一定是根节点
        int rootIndex = -1;//根据根节点的值找到根节点在中序遍历数组里的位置
        for (int i = 0; i < mid.length; i ++) {
            if (pre[0] == mid[i]) {
                rootIndex = i;
                break;
            }
        }

        int leftLen = rootIndex; //左树的长度
        int rightLen = mid.length - rootIndex - 1; //右树的长度

        if (leftLen > 0) { //获取左树的前序遍历和中序遍历值
            int[] leftPre = new int[leftLen];
            int[] leftMid = new int[leftLen];

            for(int i = 0; i < leftLen; i ++) {
                leftPre[i] = pre[i + 1];
                leftMid[i] = mid[i];
            }
            root.leftNode = construct(leftPre,leftMid); //递归生成子树
        }

        if (rightLen > 0) { //获取右树的前序遍历和中序遍历的值
            int[] rightPre = new int[rightLen];
            int[] rightMid = new int[rightLen];

            for(int i = 0; i < rightLen; i++) {
                rightPre[i] = pre[i + rootIndex + 1];
                rightMid[i] = mid[i + rootIndex + 1];
            }
            root.rightNode = construct(rightPre,rightMid); //递归生成子树
        }
        return root;
    }

    private static class BinaryTreeNode<T> {
        T val;
        BinaryTreeNode leftNode;
        BinaryTreeNode rightNode;
        BinaryTreeNode(T val) {
            this.val = val;
        }
    }
}