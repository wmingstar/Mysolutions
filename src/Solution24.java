/**
 * Created by byuwa on 2017/3/27.
 * 二叉搜索树的后续遍历
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 */

public class Solution24 {

    public static boolean verifySequenceOfBST(int[] data){
        if(data == null || data.length<1){
            return false;
        }

        return verifySequenceOfBST(data,0,data.length-1);
    }

    public static boolean verifySequenceOfBST(int[] data,int start,int end){
        if(start>=end){
            return true;
        }
        int index = start;
        while(index<end-1 && data[index]<data[end]){
            index++;
        }
        int right = index;
        while (index<end-1 && data[index]>data[end]){
            index++;
        }
        if(index!=end-1){
            return false;
        }
        index = right;
        return verifySequenceOfBST(data,start,index-1) && verifySequenceOfBST(data,index,end-1);
    }
    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /   \
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySequenceOfBST(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifySequenceOfBST(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySequenceOfBST(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySequenceOfBST(data4));

        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + verifySequenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySequenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySequenceOfBST(data7));
    }

}
