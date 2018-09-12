package com.cuiyun.offerlearn;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class _04_ReplaceBlank {

    public static void main(String[] args) {

        StringBuilder str = new StringBuilder("We Are Happy ");
        System.out.println(replaceBlank(str));
    }

    private static String replaceBlank(StringBuilder str) {
        if (str == null || str.length() == 0)
            throw new RuntimeException("str is null");

        int oldLength = str.length();
        //计算替换后的字符串所需长度
        int newLength = oldLength;
        for(int i = 0; i < oldLength; i ++) {
            if (str.charAt(i) == ' ') {
                newLength += 2;
            }
        }
        str.setLength(newLength);

        for (int i = oldLength - 1, j = newLength - 1; i >=0;) {
            if (str.charAt(i) == ' ') {
                i--;
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            }
            else {
                str.setCharAt(j--, str.charAt(i--));
            }
        }
        return str.toString();
    }
}
