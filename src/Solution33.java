/**
 * Created by byuwa on 2017/3/28.
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印出能拼接出的所有数字中最小的一个。
 */
public class Solution33 {
    public static int[] sortArray(int[] nums){
        if(nums==null || nums.length<1){
            return  null;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public static void quickSort(int[] nums,int low,int high){
        if(low<high){
            int piv = partition(nums,low,high);
            quickSort(nums,low,piv-1);
            quickSort(nums,piv+1,high);
        }
    }

    public static int partition(int nums[],int low,int high){
        int pivot = nums[low];
        while (low<high){
            while (low<high && compare(pivot,nums[high])){
                high--;
            }
            nums[low]=nums[high];
            while (low<high && compare(nums[low],pivot)){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=pivot;
        return low;
    }

    public static boolean compare(int num1,int num2){
        int result=0;
        String s1 = num1+""+num2;
        String s2 = num2+""+num1;
        result = s1.compareTo(s2);
        if(result<=0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,5,4};
        int[] result = sortArray(nums);
        String s="";
        for (int i=0;i<result.length;i++){
            s+=result[i];
        }
        System.out.print(s);
    }

}
