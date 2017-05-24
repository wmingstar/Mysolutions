/**
 * Created by byuwa on 2017/3/18.
 */
public class ShellSort {
    public static int[] shellSort(int[] nums){
        if(nums==null || nums.length<1){
            return null;
        }
       double d1 = nums.length;
        int d= (int)Math.ceil(d1/2);
        while (d>=1){
            for(int x=0;x<d;x++){
                for(int i=x+d;i<nums.length;i+=d){
                    int temp =nums[i];
                    int j=i-d;
                    for(;j>=0 && nums[j]>temp;j-=d){
                        nums[j+d]=nums[j];
                    }
                    nums[j+d]=temp;
                }
            }
            d = (int)Math.ceil(d/2);
        }
        return nums;

    }

    public static void main(String[] args){
        int[] a = {1,3,8,2,9,10,5,36,21};
        int[] b = ShellSort.shellSort(a);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}
