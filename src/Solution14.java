/**
 * Created by byuwa on 2017/3/24.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 */
public class Solution14 {
    public static int[] Recorder(int[] nums){
        if(nums == null || nums.length==0){
            return null;
        }

        int index1 = 0;
        int index2 = nums.length-1;
        while (index1<index2){
            while (index1<index2 && !isEven(nums[index1])){
                index1++;
            }
            while (index1<index2 && isEven(nums[index2])){
                index2--;
            }
            if(index1<index2){
                int temp = nums[index1];
                nums[index1]=nums[index2];
                nums[index2] = temp;
            }
        }
        return nums;
    }

    public static boolean isEven(int num){
        return (num&1)==0;
    }

    public static void main(String[] args){
        int[] nums = {1,4,2,3,5,7,8,9};
        int[] result = Solution14.Recorder(nums);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
        }
    }
}
