/**
 * Created by byuwa on 2017/3/22.
 *
 * 写一个函数，输入 n ,求斐波那契数列的第 n 项。
 *
 */
public class Solution9 {
    //直接递归，，当递归深度较深时，效率很低
    public int Fibonacci1(int n){
        if(n<0){
            throw new RuntimeException("n 小于 0，输入不合法");
        }
        if(n<2){
            return n;
        }

        return Fibonacci1(n-1)+Fibonacci1(n-2);
    }

    public int Fibonacci2(int n){
        int[] result={0,1};
        if(n<0){
            throw new RuntimeException("数组为空");
        }
        if(n<=1){
            return result[n];
        }
        int fibo_one = 0;
        int fibo_two = 1;
        int fibo_n=0;
        for(int i=2;i<=n;i++){
            fibo_n = fibo_one+fibo_two;
            fibo_one = fibo_two;
            fibo_two = fibo_n;
        }
        return fibo_n;
    }

    public static void main(String[] args){
        int n = 9;
        Solution9 s9 = new Solution9();
        int result1 = s9.Fibonacci1(n);
        int result2 = s9.Fibonacci2(n);
        System.out.println(result1);
        System.out.println(result2);
    }
}
