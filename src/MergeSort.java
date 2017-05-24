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
        int[] temp = new int[nums.length];
        int third = low;
        int left= low;
        int right = center+1;
        while (left<=center && right<=high){
            if(nums[left]<=nums[right]){
                temp[third++]=nums[left++];
            }
            else {
                temp[third++]=nums[right++];
            }
        }
        while (left<=center){
            temp[third++]=nums[left++];
        }
        while (right<=high){
            temp[third++]=nums[right++];
        }
        while (low<=high){
            nums[low]=temp[low++];
        }

    }
    public static void main(String[] args){
        int[] a= {9,2,5,4,6,12,11,25,14,15,16};
        int[] b= mergeSort(a);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }

    }

}
