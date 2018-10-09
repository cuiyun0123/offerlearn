package src.com.cuiyun.offerlearn;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 解题思路：
 * 二叉搜索树: 左子树<根<=右子树
 * 对于后序遍历来说，序列数组的最后一个元素一定是根节点,
 * 根据这个元素，将前面的数组分为左、右两个部分，左侧部分都比该元素小，
 * 右侧部分都比该元素大，如果右侧部分有比该根节点小的元素，那么就不是后序遍历，如此递归进行。
 */
public class _24_SquenceOfBST {

    public static void main(String[] args) {
        //int[] sequence = {5,7,6,9,11,10,8};
//        int[] sequence = {7,4,6,5};
        int[] sequence = {9,11,10,8};
        System.out.print(verifSequenceOfBST(sequence, sequence.length));
    }

    private static boolean verifSequenceOfBST(int[] sequence, int length) {
        if (sequence == null || length <= 0) {
            return false;
        }
        int root = sequence[length - 1];
        //查找左子树节点
        int i = 0;
        for(; i < length - 1; i++) {
            if (sequence[i] > root)
                break;
        }

        int j = i;
        for (; j < length - 1; j ++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > 0)
            left = verifSequenceOfBST(sequence, i);

        boolean right = true;
        if (i < length - 1) {
            right = verifSequenceOfBST(sequence, length - i - 1);
        }
        return (left && right);
    }
}
