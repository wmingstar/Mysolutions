/**
 * Created by byuwa on 2017/3/23.
 *
 *实现一个函数，输入一个整数，输出该二进制表示中 1 的个数
 * 同类的题:  （1）P判断一个数是否是  2 的整数次方 （当 是 2 的整数次方时，只有一位为 1）
 *            （2）判断两个数的二进制表示 中有几位是相异  （先异或 再求 1 的个数）
 */
public class Solution10 {
    //这种解法是错的，当输入为 负数时，右移时，高位补1，会陷入死循环
    public int countNumOf1(int num){
        int time = 0;
        while(num!=0){

            if((num&1)==1){
                time++;
            }
            num=num>>1;
        }
        return time;
    }

    public int countNumOf1_1(int num) {
        int time = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) == 1) {
                time++;
            }
            flag=flag<<1;
        }
        return time;
    }

    public int countNumOf1_2(int num){
        int time = 0;
        while(num!=0){
            time++;
            num=(num-1)&num;
        }
        return time;
    }

    public static void main(String[] args){
        Solution10 test = new Solution10();
        int result1 = test.countNumOf1_1(22);
        int result2 = test.countNumOf1_2(22);
        System.out.println(result1);
        System.out.println(result2);
    }

}
