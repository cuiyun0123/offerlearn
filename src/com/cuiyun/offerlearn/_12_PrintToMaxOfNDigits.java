package src.com.cuiyun.offerlearn;

/**
 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999
 */
public class _12_PrintToMaxOfNDigits {

    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }

    private static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("the input number must larger than 0");
        }
        int[] arr = new int[n];
        print1ToMaxOfNDigits(0, arr);
    }

    private static void print1ToMaxOfNDigits(int n, int[] arr) {
        if (n >= arr.length) {
            printArray(arr);
        } else {
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                print1ToMaxOfNDigits(n + 1, arr);
            }
        }
    }

    private static void printArray(int[] arr) {
        int index = 0;
        while(index < arr.length && arr[index] == 0) {
            index ++;
        }

        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        if (index < arr.length) {
            System.out.println();
        }
    }
}
