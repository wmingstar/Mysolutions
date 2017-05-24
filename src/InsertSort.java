/**
 * Created by byuwa on 2017/3/16.
 * 插入排序
 *
 * 假设 前 n-1 个数有序，将第n个数插入
 *
 */
public class InsertSort {
    public static int[] insertSort(int[] nums){
        if(nums == null || nums.length<1){
            return null;
        }
        for(int i=1;i<nums.length;i++){
            int temp = nums[i];
            int j=i-1;
            for(;j>=0 && nums[j]>temp;j--){
                 nums[j+1]=nums[j];
            }
            nums[j+1]=temp;
        }
        return nums;
    }
    public static void main(String[] args){
        int[] a = {1,3,8,2,9,10,5,36,21};
        int[] b = InsertSort.insertSort(a);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }

}
