/**
 * Created by byuwa on 2017/3/23.
 * 实现函数  double Power(double base,int exponent) 求 base 的 exponent 次方
 * 注意考虑边界条件  ：  base 为0   或者  exponent 小于 1 为负数
 *
 */
public class Solution11 {
    public static double Power(double base,int exponent){
        if(base==0 && exponent<=0){
            throw new RuntimeException("底数为0，幂小于等于0");
        }
        if (base ==0 && exponent>0){
            return 0.0;
        }
        if(exponent==0){
            return 1.0;
        }
        if(exponent==1){
            return base;
        }

        int exp=exponent;
        if(exponent<0){
            exp=-exp;
        }
        double result = powerByExp(base,exp);
        if(exponent<0){
            result=1/result;
        }
        return result;

    }

    public static double powerByExp(double base,int exp){
        if(exp==0){
            return 1.0;
        }

        if(exp==1){
            return base;
        }
        double result = powerByExp(base,exp>>1);
        result *= result;
        if(exp%2==1){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args){
        double result = Solution11.Power(3.6,6);
        System.out.print(result);
    }


}
