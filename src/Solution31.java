/**
 * Created by byuwa on 2017/3/28.
 * 输入一个整型数组，数组里有正数也有负数，数组中一个或连续的多个整数组成一个子数组，
 * 求所有子数组的和的最大值，要求时间复杂度为O(n)。
 *
 */
public class Solution31 {
    public static int findGreatSum(int[] nums){
        if(nums==null || nums.length<1){
            return 0;
        }
        int cur_sum = 0;
        int great_sum = 0;
        for(int i=0;i<nums.length;i++){
            if(cur_sum<=0){
                cur_sum=nums[i];
            }
            else {
                cur_sum+=nums[i];
            }
            if(cur_sum>great_sum){
                great_sum = cur_sum;
            }
        }
        return great_sum;
    }

    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};

        System.out.println(findGreatSum(data));
        System.out.println(findGreatSum(data2));
        System.out.println(findGreatSum(data3));
    }
}
