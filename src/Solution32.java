/**
 * Created by byuwa on 2017/3/28.
 * 输入一个整数 n ，求从 1 到 n 这 n 个整数的十进制表示中 1 出现的次数。
 *
 */
public class Solution32 {
    public static int countNumOf1(int n){
        if(n<1){
            return 0;
        }
        int count = 0;
        for(int i=1;i<=n;i++){
            count+=numOf1(i);
        }
        return count;
    }

    public static int numOf1(int n){
        int count = 0;
        while(n!=0){
            if(n%10==1){
                count++;
            }
            n=n/10;
        }
        return count;
    }

    public static void main(String[] args){
        int result = countNumOf1(12);
        System.out.print(result);
    }
}
