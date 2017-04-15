/**
 * Created by byuwa on 2017/3/31.
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用  + - * /
 */
public class Solution47 {
    public static int sumOfNum(int num1,int num2){
        int sum =0;
        int carry = 0;
        do{
            sum = num1^num2;
            carry=(num1&num2)<<1;

            num1=sum;
            num2=carry;
        }while (num2!=0);
        return num1;

    }
}
