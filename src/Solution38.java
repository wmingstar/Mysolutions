/**
 * Created by byuwa on 2017/3/30.
 *
 * 统计一个数字在排序数组中出现的次数
 */
public class Solution38 {
    public static int getNumOfK(int[] nums,int k){
        if(nums == null || nums.length<1){
            return 0;
        }
        int first = getFirstK(nums,nums.length,0,nums.length-1,k);
        int last =getLastK(nums,nums.length,0,nums.length-1,k);
        if(first>-1 && last>-1){
            return (last-first)+1;
        }
        return 0;
    }

    public static int getFirstK(int[] nums,int length,int start,int end,int k){
        if(start>end){
            return -1;
        }
        int middle_index = (start+end)/2;
        int middle_data = nums[middle_index];

        if(middle_data==k){
            if(middle_index>0 && nums[middle_index-1]!=k || middle_index==0){
                return middle_index;
            }
            else{
                end = middle_index-1;
            }
        }
        else if(middle_data>k){
            end = middle_index-1;
        }
        else {
            start = middle_index +1;
        }
        return getFirstK(nums,length,start,end,k);
    }

    public static int getLastK(int[] nums,int length,int start,int end,int k){
        if(start>end){
            return -1;
        }
        int middle_index = (start+end)/2;
        int middle_data = nums[middle_index];

        if(middle_data==k){
            if(middle_index<length-1 && nums[middle_index+1]!=k || middle_index==length-1){
                return middle_index;
            }
            else{
                start = middle_index+1;
            }
        }
        else if(middle_data>k){
            end = middle_index-1;
        }
        else {
            start = middle_index +1;
        }
        return getLastK(nums,length,start,end,k);
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,3,3,6,8};
        int count = getNumOfK(nums,3);
        System.out.print(count);
    }


}

