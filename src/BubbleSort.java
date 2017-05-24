/**
 * Created by byuwa on 2017/3/18.
 *
 *
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

    public static void main(String[] args){
        int[] a = {1,3,8,2,9,10,5,36,21};
        int[] b = BubbleSort.bubbleSort(a);
        if(b==null){
            System.out.print("待排序数组为空");
        }
        else{
            for(int i=0;i<b.length;i++){
                System.out.println(b[i]);
            }
        }
    }
}


