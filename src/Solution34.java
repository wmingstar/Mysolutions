/**
 * Created by byuwa on 2017/3/28.
 * 我们把只包含因子 2，3，5的数称为丑数，求按从小到大的顺序的第1500个丑数。
 * （习惯上把 1 当作第一个丑数）
 *
 */
public class Solution34 {
    public static int getUglyNum(int k){
        if(k<1){
            return 0;
        }

        int[] ugly_nums = new int[k];
        ugly_nums[0]=1;
        int index = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while(index<k){
            int min = min_num(ugly_nums[p2]*2,ugly_nums[p3]*3,ugly_nums[p5]*5);
            ugly_nums[index] = min;
            while (ugly_nums[p2]*2<=ugly_nums[index]){
                p2++;
            }

            while (ugly_nums[p3]*3<=ugly_nums[index]){
                p3++;
            }
            while (ugly_nums[p5]*5<=ugly_nums[index]){
                p5++;
            }
            index++;
        }
        return ugly_nums[index-1];

    }

    public static int min_num(int num1,int num2,int num3){
        int min = num1<num2?num1:num2;
        min = min<num3?min:num3;
        return min;
    }

    public static void main(String[] args) {
        int result = getUglyNum(1500);
        System.out.print(result);
    }
}
