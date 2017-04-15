/**
 * Created by byuwa on 2017/3/27.
 * 数组中出现次数超过一半的数字
 *
 */
public class Solution29 {
    public static int findMoreThanHalf(int[] nums){
        if(nums==null || nums.length<1){
             return 0;
        }
        int middle = nums.length>>1;
        int start = 0;
        int end = nums.length-1;
        int index = partition(nums,start,end);
        while (index!=middle){
            if(index>middle){
                end = index-1;
                index = partition(nums,start,end);
            }
            else {
                start = index+1;
                index = partition(nums,start,end);
            }
        }

        int result = nums[middle];
        if(check(nums,result)){
            return result;
        }
        return 0;
    }

    public static boolean check(int[] nums,int num){
       boolean result = false;
       int time = 0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]==num){
               time++;
           }
       }
       if(time>(nums.length/2)){
           result = true;
       }
       return result;
    }

    public static int partition(int[] nums,int start,int end){
        int pivot = nums[start];
        while (start<end){
            while (start<end && nums[end]>=pivot){
                end--;
            }
            nums[start]=nums[end];
            while (start<end && nums[start]<=pivot){
                start++;
            }
            nums[end]=nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(findMoreThanHalf(numbers));

        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(findMoreThanHalf(numbers2));

        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(findMoreThanHalf(numbers3));

        // 只有一个数
        int numbers4[] = {1};
        System.out.println(findMoreThanHalf(numbers4));

        // 输入空指针
        System.out.println(findMoreThanHalf(null));
        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(findMoreThanHalf(numbers5));
    }


}
