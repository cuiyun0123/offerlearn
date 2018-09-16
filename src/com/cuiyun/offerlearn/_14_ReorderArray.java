package src.com.cuiyun.offerlearn;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 */
public class _14_ReorderArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        reorderOddEven(arr);
        print(arr);
    }

    private static void reorderOddEven(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int beginIndex = 0;
        int endIndex = arr.length - 1;
        while (beginIndex < endIndex) {

            //从前往后找偶数
            while(beginIndex <endIndex && arr[beginIndex] % 2 != 0) {
                beginIndex ++;
            }

            //从后往前找奇数
            while(beginIndex < endIndex && arr[endIndex] % 2 == 0) {
                endIndex --;
            }

            if (beginIndex < endIndex) {
                int temp = arr[beginIndex];
                arr[beginIndex] = arr[endIndex];
                arr[endIndex] = temp;
            }
        }
    }

    private static void print(int[] arr) {
        for (int i: arr) {
            System.out.print(i);
        }
    }
}
