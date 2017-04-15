import java.util.HashMap;

/**
 * Created by byuwa on 2017/4/1.
 * 在一个长度为 n  的数组里的所有数字都在 n-1 的范围内。数组中某些是重复的，但不知道有几个数字重复了，也不知道每个数字
 * 重复了几次。
 *
 * 请找出任意一个重复的数字。
 *
 */
public class Solution51 {
    //方法一   遍历数组，将数组放入hashmap，键为数字，值为出现的次数
    public void findDuplicateNums1(int[] nums){
        if(nums==null || nums.length<1){
            System.out.print("数组为空");
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0 || nums[i]>(nums.length-1)){
                System.out.print("数组不符合要求");
                return;
            }
        }

        HashMap dic = new HashMap();
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(dic.containsKey(nums[i])){
                count = (int)dic.get(nums[i])+1;
                dic.put(nums[i],count);
            }
            else {
                dic.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if((int)dic.get(nums[i])>1){
                System.out.println(nums[i]);
                return;
            }
        }
    }

    //方法二   不用额外空间，调整数组中数的顺序
    public void findDuplicateNums2(int[] nums) {
        if (nums == null || nums.length < 1) {
            System.out.print("数组为空");
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0 || nums[i]>(nums.length-1)){
                System.out.print("数组不符合要求");
                return;
            }
        }
        //这样 不一定能找到重复的数字
//       for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == i) continue;
//            else {
//                if (nums[i] == nums[nums[i]]) {
//                    System.out.println(nums[i]);
//                    return;
//                }
//                int temp = nums[i];
//                nums[i] = nums[temp];
//                nums[temp] = temp;
//            }
//        }
        for(int i=0;i<nums.length;i++){
            //若有重复的，则一定会有nums[i]!=i，不断交换，一定 有 nums[i]==nums[nums[i]]
            //若没有重复，则一定最终 每个位置 nums[i]==i
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    System.out.print(nums[i]);
                    return;
                }
                int temp =nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]]=temp;
            }
        }
    }

    public static void main(String[] args){
        int[] test = {2,3,1,0,2,5,3};
        Solution51 s = new Solution51();
        s.findDuplicateNums1(test);
        s.findDuplicateNums2(test);
    }




}
