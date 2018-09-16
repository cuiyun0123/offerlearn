package src.com.cuiyun.offerlearn;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 */
public class _11_Power {

    public static void main(String[] args) {
        System.out.println(Math.pow(2,-1));
        System.out.println(power(2,-1));
    }

    private static double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1)
            return base;

        boolean positive = exponent > 0;
        exponent = positive ? exponent : -exponent;

        double result =  1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        if (!positive) {
            result = 1 / result;
        }
        return result;
    }
}
