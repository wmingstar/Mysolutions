/**
 * Created by byuwa on 2017/4/1.
 * 构建乘积数组
 *
 * 题目：给定一个数组A[0,1,…,n-1],
 * 请构建一个数组B[0,1,…,n-1],其中B中的元素B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1],不能使用除法。
 */
public class Solution52 {
    public static int[] multiply(int[] nums){
        if(nums==null || nums.length<2){
            return null;
        }
        int[] result=new int[nums.length];
        result[0]=1;
        for(int i=1;i<nums.length;i++){
            result[i]=result[i-1]*nums[i-1];
        }
        int temp=1;
        for(int i=nums.length-2;i>=0;i--){
            temp*=nums[i+1];
            result[i]*=temp;
        }
        return result;
    }
}
