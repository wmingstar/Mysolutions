/**
 * Created by byuwa on 2017/3/28.
 * 输入一个整型数组，数组里有正数，有负数，数组中一个或连续多个正数组成一个子数组。求所有子数组的和的最大值。
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
}
