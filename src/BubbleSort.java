/**
 * Created by byuwa on 2017/3/18.
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] nums){
        if(nums==null || nums.length<1){
            return null;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
}
