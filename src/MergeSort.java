/**
 * Created by byuwa on 2017/3/19.
 */
public class MergeSort {
    public static int[] mergeSort(int[] nums){
        if(nums==null || nums.length<1){
            return null;
        }
        m_sort(nums,0,nums.length-1);
        return nums;
    }

    public static void m_sort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int middle = (low+high)/2;
        m_sort(nums,low,middle);
        m_sort(nums,middle+1,high);
        merge(nums,low,middle,high);
    }
    public static void merge(int nums[],int low,int center,int high){
        int index = low;
        int third = low;
        int right = center+1;
        int[] temp=new int[nums.length];
        while(low<=center && right<=high){
            if(nums[low]<=nums[right]){
                temp[third++]=nums[low++];
            }
            else{
                temp[third++]=nums[right++];
            }
        }
        while (low<=center){
            temp[third++]=nums[low++];
        }
        while (right<=high){
            temp[third++]=nums[right++];
        }
        while (third<=high){
            nums[third]=temp[third++];
        }
    }
}
