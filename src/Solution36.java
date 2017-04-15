/**
 * Created by byuwa on 2017/3/30.
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对，输入一个数组，求出这个数组中的逆序对的
 * 总数。
 *
 * 例如：在数组 {7，5，6，4} 中存在5个逆序对  分别是（7，6） （7，5） （7，4）  （6，4） （5，4）
 */
public class Solution36 {
    public static int inversePairs(int[] nums){
        if(nums==null || nums.length<1){
            return 0;
        }
        int[] temp = new int[nums.length];
        System.arraycopy(nums,0,temp,0,nums.length);
        int count = inversePairsCount(nums,temp,0,nums.length-1);
        return count;
    }
    public static int inversePairsCount(int[] nums,int[] temp,int start,int end){
        if(start==end){
            return 0;
        }

        int middle=(start+end)/2;
        int i = middle;
        int j = end;
        int third=end;
        int count = 0;
        int left = inversePairsCount(temp,nums,start,middle);
        int right = inversePairsCount(temp,nums,middle+1,end);
        while (i>=start && j>=middle+1){
            if(nums[i]>nums[j]){
                temp[third--] = nums[i--];
                count+=j-middle;
            }
            else{
                temp[third--]=nums[j--];
            }

        }
        while (i>=start){
            temp[third--] = nums[i--];
        }
        while (j>=middle+1){
            temp[third--] = nums[j--];
        }
        count = count+left+right;
        return count;
    }
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(inversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(data2)); //  15
        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(inversePairs(data3)); // 0
        int[] data4 = {1};
        System.out.println(inversePairs(data4)); // 0
        int[] data5 = {1, 2};
        System.out.println(inversePairs(data5)); // 0
        int[] data6 = {2, 1};
        System.out.println(inversePairs(data6)); // 1
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(inversePairs(data7)); // 3
    }


}
