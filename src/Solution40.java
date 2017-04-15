import java.util.HashMap;

/**
 * Created by byuwa on 2017/3/31.
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 找出只出现一次的数字，要求时间复杂度是  O(n)  空间复杂度是 O(1)
 */
public class Solution40 {

    //用 Hashmap 的方式，时间复杂度为 O（n），但是空间复杂度为 O（n）
    public static void findNums1(int[] nums){
        if(nums==null && nums.length<1){
            System.out.print("数组为空");
            return;
        }
        HashMap dic = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            if(dic.containsKey(nums[i])){
                dic.put(nums[i],2);
            }
            else{
                dic.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            int count = (int)dic.get(nums[i]);
            if(count==1){
                System.out.println(nums[i]);
            }
            else{
                continue;
            }
        }
        System.out.println("************");
    }

    public static void findNums2(int[] nums){
        if(nums==null && nums.length<1){
            System.out.print("数组为空");
            return;
        }
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            temp^=nums[i];
        }
        int index = getFirstBitOf1(temp);
        int result1=0;
        int result2=0;
        for(int i=0;i<nums.length;i++){
            temp = nums[i]>>index;
            if((temp&1)==1){
                result1^=nums[i];
            }
            else{
                result2^=nums[i];
            }
        }
        System.out.format("%d, %d",result1,result2);
    }

    public static int getFirstBitOf1(int num){
        int index = 0;
        while ((num&1)!=1 && index<32 ){
            num=num>>1;
            index++;
        }
        return index;
    }
    public static void main(String[] args){
        int[] data={1,2,3,3,4,4,5,5};
        findNums1(data);
        findNums2(data);
    }


}
