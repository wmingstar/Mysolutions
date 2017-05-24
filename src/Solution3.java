/**
 * Created by byuwa on 2017/3/19.
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 输入：二维数组  整数
 * 输出：boolean
 */
public class Solution3 {
    public static boolean findNum(int[][] data,int num){
        if (data==null || data.length<1 || data[0].length<1){
            throw new RuntimeException("数组为空");
        }
        int index_r = 0;
        int index_c = data[0].length-1;
        //从右上角元素开始查找
        while(index_r<=data.length-1 && index_c>=0){
            if(data[index_r][index_c]==num){
                return true;
            }
            else if (data[index_r][index_c]>num){
                index_c=index_c-1;
            }
            else{
                index_r=index_r+1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] data = {{1,2,3},{4,7,8},{5,8,9}};
        int num = 10;
        boolean result = Solution3.findNum(data,num);
        System.out.print(result);
    }
}
