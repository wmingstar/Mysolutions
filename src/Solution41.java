import java.util.HashMap;

/**
 * Created by byuwa on 2017/3/31.
 * 题目一
 * 输入一个递增排序的数组和一个数字S,在数组中查找两个数，使得它们的和正好是S,如果有多对，输出任意一对即可。
 *
 * 题目二
 * 输入一个整数，打印出所有和为s的连续整数序列
 *
 *
 */
public class Solution41 {
    public static void findNums1(int[] nums,int s){
        if(nums==null || nums.length<1){
            return;
        }
        HashMap dic = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(dic.containsKey(nums[i])){
                dic.put(nums[i],2);
            }
            else{
                dic.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            int diff = s-nums[i];
            if(dic.containsKey(diff)){
                if(diff*2==s){
                    if((int)dic.get(diff)==2){
                        System.out.printf("满足要求的数：%d，%d",diff,nums[i]);
                    }

                }
                else{
                    System.out.printf("满足要求的数：%d，%d",diff,nums[i]);
                }

            }
        }
    }

    public static void findNums2(int[] nums,int s){
        if(nums==null || nums.length<1){
            return;
        }
        int index1=0;
        int index2=nums.length-1;
        while (index1<index2){
            int sum = nums[index1]+nums[index2];
            if(sum==s){
                System.out.printf("满足要求的数：%d，%d",nums[index1],nums[index2]);
                return;
            }
            else if(sum>s){
                index2--;
            }
            else {
                index1++;
            }

        }
        System.out.printf("没有满足要求的数");

    }

    public static void findContinuousSequence(int sum){
        if(sum<3){
            return;
        }
        int small =1;
        int big=2;
        int cur_sum = small+big;
        int middle = (1+sum)/2;
        while (small<middle){
            if(cur_sum==sum){
                printNums(small,big);
            }
            while (cur_sum>sum && small<middle){
                cur_sum-=small;
                small++;
                if(cur_sum==sum){
                    printNums(small,big);
                }
            }
            big++;
            cur_sum+=big;
        }

    }

    public static void printNums(int start,int end){
        for(int i=start;i<=end;i++){
            System.out.format("  %d",i);
        }
        System.out.print("\n");
        System.out.println("******************");
    }

    public static void main(String[] args){
        findContinuousSequence(15);
    }


}
