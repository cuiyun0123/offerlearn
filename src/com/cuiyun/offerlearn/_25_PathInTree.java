package src.com.cuiyun.offerlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class _25_PathInTree {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(7);
        root.right = new BinaryTreeNode(12);



        _25_PathInTree t = new _25_PathInTree();
        t.findPath(root, 22);
        for(List<Integer> list : t.res) {
            for (Integer index : list) {
                System.out.print(index + "\t");
            }
            System.out.println();
        }
    }

    ArrayList<ArrayList<Integer> > res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode root,int target) {
        if(root == null)
            return res;
        target -= root.val;
        temp.add(root.val);
        if(target == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(temp));
        else{
            findPath(root.left, target);
            findPath(root.right, target);
        }
        temp.remove(temp.size()-1);
        return res;
    }


    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }

}
