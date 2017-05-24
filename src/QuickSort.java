/**
 * Created by byuwa on 2017/3/18.
 */
public class QuickSort {
    public static int[]  quickSort(int[] nums){
        if(nums==null || nums.length<1){
            return null;
        }
        qsort(nums,0,nums.length-1);
        return nums;
    }
    public static void qsort(int[] nums,int low,int high){
        if(low<high){
            int piv=partition(nums,low,high);
            qsort(nums,low,piv-1);
            qsort(nums,piv+1,high);
        }
    }
    public static int partition(int[] nums,int low,int high){
        int pivot=nums[low];
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
        int[] a= {9,2,5,4,6,12,11,25,14,15,16};
        int[] b= quickSort(a);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }

    }

}
