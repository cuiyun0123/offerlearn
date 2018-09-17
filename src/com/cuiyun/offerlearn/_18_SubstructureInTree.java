package src.com.cuiyun.offerlearn;

/**
 * 题目：输入两颗二叉树A和B，判断B 是不是A 的子结构
 */
public class _18_SubstructureInTree {

    public static void main(String[] args) {

        BinaryTreeNode<Integer> aTree = new BinaryTreeNode<>();
        aTree.val = 8;
        aTree.left = new BinaryTreeNode<>();
        aTree.left.val = 8;
        aTree.right = new BinaryTreeNode<>();
        aTree.right.val = 7;
        aTree.left.left = new BinaryTreeNode<>();
        aTree.left.left.val = 9;
        aTree.left.right = new BinaryTreeNode<>();
        aTree.left.right.val = 2;

        BinaryTreeNode<Integer> bTree = new BinaryTreeNode<>();
        bTree.val = 8;
        bTree.left = new BinaryTreeNode<>();
        bTree.left.val = 9;
        bTree.right = new BinaryTreeNode<>();
        bTree.right.val = 2;

        System.out.println(hashSubTree(aTree, bTree));
    }

    private static boolean hashSubTree(BinaryTreeNode<Integer> aTree, BinaryTreeNode<Integer> bTree) {
        if (aTree == null || bTree == null)
            return false;
        if (aTree == bTree)
            return true;

        boolean result = false;
        if (aTree.val == bTree.val) {
            result = DoesATreeHaveBTree(aTree, bTree);
        }
        if (!result) {
            result = hashSubTree(aTree.left, bTree);
        }
        if (!result) {
            result = hashSubTree(aTree.right, bTree);
        }
        return result;
    }

    private static boolean DoesATreeHaveBTree(BinaryTreeNode<Integer> aTree, BinaryTreeNode<Integer> bTree) {

        if (aTree == bTree)
            return true;
        if (aTree == null)
            return false;
        if (bTree == null)
            return true;

        if (aTree.val != bTree.val)
            return false;

        return DoesATreeHaveBTree(aTree.left, bTree.left) && DoesATreeHaveBTree(aTree.right, bTree.right);
    }


    /**
     * 二叉树
     * @param <T>
     */
    private static class BinaryTreeNode<T> {
        T val;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }
}
