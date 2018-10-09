package src.com.cuiyun.offerlearn;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字
 *
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 *
 * 输出：1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 *
 */
public class _20_PrintMatrix {

    public static void main(String[] args) {

        int[][] numbers = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printMatrixClockwisely(numbers);
    }

    private static void printMatrixClockwisely(int[][] numbers) {
        if (numbers == null)
            return;

        int x = 0; //开始位置的x坐标，从0开始
        int y = 0; //开始位置的y坐标，从0开始

        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printMatrixInCircle(numbers, x, y);
            x ++;
            y ++;
        }
    }

    private static void printMatrixInCircle(int[][] numbers, int x, int y) {

        int rows = numbers.length;
        int cols = numbers[0].length;

        //输出环的最上面一行
        for (int i = y; i <= cols - y - 1; i ++) {
            System.out.print(numbers[x][i] + "  ");
        }

        if (rows - x - 1 > x) {
            // 因为右边那一列的最上面那一个已经被输出了，所以行呈从x+1开始，
            // 输出包括右边那列的最下面那个
            for (int i = x + 1; i <= rows - x - 1; i++) {
                System.out.print(numbers[i][cols - y - 1] + " ");
            }
        }

        // 环的高度至少是2并且环的宽度至少是2才会输出下面那一行
        // cols-1-y：表示的是环最右那一列的列号
        if (rows - x - 1 > x && cols - 1 - y > y) {
            // 因为环的左下角的位置已经输出了，所以列号从cols-y-2开始
            for (int i = cols - y - 2; i >= y; i--) {
                System.out.print(numbers[rows - 1 - x][i] + " ");
            }
        }

        // 环的宽度至少是2并且环的高度至少是3才会输出最左边那一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            // 因为最左边那一列的第一个和最后一个已经被输出了
            for (int i = rows - 1 - x - 1; i >= x + 1; i--) {
                System.out.print(numbers[i][y] + " ");
            }
        }
    }
}
