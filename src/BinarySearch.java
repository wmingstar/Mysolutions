/**
 * Created by byuwa on 2017/3/19.
 *
 *
 * 二分查找又称折半查找，它是一种效率较高的查找方法。 【二分查找要求】：
 * 1.必须采用顺序存储结构
 * 2.必须按关键字大小有序排列。
 *   有序数组
 *   查找元素
 * @return searchKey的数组下标，没找到返回-1
 */
public class BinarySearch {
    public static int binarySearch(int[] nums,int num){
        if(nums==null || nums.length<1){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while (low<high){
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
        int num=12;
        int index = BinarySearch.binarySearch(nums,num);
        System.out.print(index);

    }
}
