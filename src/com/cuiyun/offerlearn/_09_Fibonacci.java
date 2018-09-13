package com.cuiyun.offerlearn;

/**
 * 题目：斐波那契数列
 *
 * f(n) = f(n-1) + f(n-2)
 *
 * 0 1 1 2 3 5 8 13.....
 */
public class _09_Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
        System.out.println(fibonacciForLoop(7));
    }

    /**
     * 递归方式
     * @param number
     * @return
     */
    private static int fibonacci(int number) {
        if (number <= 0)
            return 0;
        if (number == 1)
            return 1;

        return fibonacci(number - 1) + fibonacci(number - 2);
    }


    /**
     * 循环方式,效率高，推荐
     * @param number
     * @return
     */
    private static int fibonacciForLoop(int number) {

        if (number <= 0)
            return 0;
        if (number == 1)
            return 1;

        int oneNumber = 1; //f(n-1)
        int twoNumber = 0; //f(n-2)
        int result = 0;
        for (int i = 2; i <= number; i ++) {
            result = oneNumber + twoNumber; //f(n) = f(n-1) + f(n-2)

            twoNumber = oneNumber;
            oneNumber = result;
        }
        return result;
    }
}