/**
 * Created by byuwa on 2017/3/20.
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 */
public class Solution8 {
    public static int findMinNum(int[] nums){
        if(nums==null || nums.length<1){
            throw new RuntimeException("数组为空");
        }
        if(nums.length==1){
            return nums[0];
        }
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                min  = nums[i];
            }
        }
        return min;
    }

    public static int findMinNum2(int[] nums){
        if(nums==null || nums.length<1){
            throw new RuntimeException("数组为空");
        }
        if(nums.length==1){
            return nums[0];
        }
        int index1 = 0;
        int index2 = nums.length-1;
        int middle = (index1+index2)>>1;
        int min;
        if(nums[index2]>nums[index1]){
            min = nums[index1];
            return min;
        }

        if(nums[index1]==nums[middle] && nums[index2]==nums[middle]){
            min = nums[index1];
            for(int i=1;i<nums.length;i++){
                if(nums[i]<min){
                    min = nums[i];
                }
            }
            return min;
        }

        while ((index2-index1)!=1){
            if(nums[middle]>=nums[index1]){
                index1=middle;
            }
            if(nums[middle]<=nums[index2]){
                index2=middle;
            }
            middle=(index1+index2)>>1;
        }
        min = nums[index2];
        return min;
    }

    public static void main(String args[]) throws Exception {
        int[] a = {4,5,1,2,3};
        int result1,result2;
        result1 = Solution8.findMinNum(a);
        result2 = Solution8.findMinNum2(a);
        System.out.println(result1);
        System.out.println(result2);
    }
}
