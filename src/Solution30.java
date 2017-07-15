/**
 * Created by byuwa on 2017/3/28.
 *
 * 输入 n 个整数，找出其中最小的的 K 个数。
 */
public class Solution30 {
    public static void findNums(int[] nums ,int k){
        if(nums==null || nums.length<1 || k<1 || k>nums.length){
            System.out.print("输入不合法");
            return;
        }
        if(k==nums.length){
            for(int i=0;i<k;i++){
                System.out.print(nums[i]);
            }
            return;
        }
        int low = 0;
        int high = nums.length-1;
        int index = partition(nums,low,high);
        while(index!=k){
            if(index>k){
                high=index-1;
                index = partition(nums,low,high);
            }
            else{
                low = index+1;
                index = partition(nums,low,high);
            }
        }
        for(int i =0;i<k;i++){
            System.out.print(nums[i]);
        }

    }

    public static int partition(int nums[],int low,int high){
        int pivot = nums[low];
        while (low<high){
            while (low<high && nums[high]>=pivot){
                high--;
            }
            nums[low]=nums[high];
            while (low<high && nums[low]<=pivot){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=pivot;
        return low;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        findNums(nums,8);
    }
}
