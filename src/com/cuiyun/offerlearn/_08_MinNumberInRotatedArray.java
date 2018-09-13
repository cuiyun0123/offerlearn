package com.cuiyun.offerlearn;

/**
 * 旋转数组的最小数字
 * 题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的
 * 旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组 {3,4,5,1,2}为 {1,2,3,4,5}的一个旋转，该数组的最小值为 1
 */
public class _08_MinNumberInRotatedArray {

    public static void main(String[] args) {
//        int[] numbers =  {3,4,5,1,2};
//        int[] numbers =  {3,4,1,2,3};
        int[] numbers =  {1,0,1,1,1};
        System.out.println(min(numbers));
    }

    private static int min(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            throw new IllegalArgumentException("parm error!");

        int index1 = 0;
        int index2 = numbers.length - 1;
        int midIndex = index1;

        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                midIndex = index2;
                break;
            }
            midIndex = (index1 + index2) / 2;
            //如果下标index1、index2、indexMid指向的三个数相等，则只能顺序查找
            if (numbers[index1] == numbers[midIndex] && numbers[index1]==numbers[index2]) {
                return minInOrder(numbers);
            }


            if (numbers[midIndex] >= numbers[index1]) {
                index1 = midIndex;
            }
            else {
                index2 = midIndex;
            }
        }
        return numbers[midIndex];
    }

    private static int minInOrder(int[] numbers) {
        int min = numbers[0];
        for(int i = 1; i < numbers.length; i ++) {
            if (min > numbers[i])
                min = numbers[i];
        }
        return min;
    }
}
