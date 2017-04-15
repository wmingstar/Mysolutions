/**
 * Created by byuwa on 2017/3/18.
 */
public class ShellSort {
    public static int[] shellSort(int[] nums){
        if(nums==null || nums.length<1){
            return null;
        }
        double d1=nums.length;
        int d=(int)(Math.ceil(d1/2));
        while (d>=1){
            for(int x =0;x<d;x++){
                for(int i=x+d;i<nums.length;i+=d){
                    int j=i-d;
                    int temp = nums[i];
                    for(;j>=0 && nums[j]>temp;j-=d){
                        nums[j+d]=nums[j];
                    }
                    nums[j+d]=temp;
                }
            }
            d=(int)(Math.ceil(d/2));
        }
        return nums;

    }
}
