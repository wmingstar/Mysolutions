/**
 * Created by byuwa on 2017/3/19.
 *
 *
 * 二分查找又称折半查找，它是一种效率较高的查找方法。 【二分查找要求】：
 * 1.必须采用顺序存储结构
 * 2.待查找的序列为按关键字大小有序排列的数组。
 */
public class BinarySearch {
    public static int binarySearch(int[] nums,int num){
        if(nums==null || nums.length<1){
            System.out.print("待查找数组为空");
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int middle = (low+high)/2;
            if(nums[middle]==num){
                return middle;
            }
            else if(nums[middle]>num){
                high=middle-1;
            }
            else {
                low=middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums={1,2,3,4,5,6,7,8,9};
        int num=4;
        int index = BinarySearch.binarySearch(nums,num);
        System.out.print(index);

    }
}
