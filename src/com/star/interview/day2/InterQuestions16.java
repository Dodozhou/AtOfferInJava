package com.star.interview.day2;

/**
 * 数值的整数次方
 */
public class InterQuestions16 {
    /**
     * 计算一个数的整数次方
     * @param base 底数
     * @param exponent 指数
     * @return 结果
     * @throws Exception 求0的0次方
     */
    public static double Power(double base,int exponent) throws Exception {
        boolean isNegative = false;
        if (base == 0 && exponent == 0)
            throw new Exception("pow(0,0)");
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;

        if (exponent<0) {
            isNegative = true;
            exponent= (-exponent);
        }
        double result = powerWithAbsExp(base,exponent);
        if (isNegative)
            result = (-result);
        return result;
    }

    /**
     * 使用exponent的绝对值，先求平方，在平方的基础上求4次方，然后8次方....
     * @param base 底数
     * @param exponent 指数的绝对值
     * @return 结果的绝对值
     */
    private static double powerWithAbsExp(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = powerWithAbsExp(base,exponent >>1);
        result *= result;
        if (exponent %2 == 1)
            result *= base;

        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Power(2.0,3));
    }

}
