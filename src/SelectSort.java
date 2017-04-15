/**
 * Created by byuwa on 2017/3/16.
 */
public class SelectSort {
     public static int[] selectSort(int[] nums){
         if(nums==null || nums.length<1){
             return null;
         }
         for(int i=0;i<nums.length;i++){
             int j = i+1;
             int temp=nums[i];
             int position=i;
             for(;j<nums.length;j++){
                 if(nums[j]<temp){
                     temp=nums[j];
                     position=j;
                 }
             }
             nums[position]=nums[i];
             nums[i]=temp;
         }
         return nums;
     }
}
