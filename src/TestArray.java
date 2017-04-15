/**
 * Created by byuwa on 2017/3/18.
 * 排序算法  测试
 *
 */
public class TestArray {
    public static void main(String[] args){
        int[] test={10,31,12,16,9,21,6,8,13,16,18,11};
        //插入排序
        int[] result1=InsertSort.insertSort(test);
        //选择排序
        int[] result2=SelectSort.selectSort(test);
        //希尔排序
        int[] result3=ShellSort.shellSort(test);
        //冒泡排序
        int[] result4=BubbleSort.bubbleSort(test);
        //快速排序
        int[] result5=QuickSort.quickSort(test);
        //归并排序
        int[] result6=QuickSort.quickSort(test);

        System.out.print("插入排序");
        for(int i =0;i<result1.length;i++){
            System.out.print(" "+ result1[i]);
        }
        System.out.print("\n选择排序");
        for(int i =0;i<result2.length;i++){
            System.out.print(" "+ result2[i]);
        }
        System.out.print("\n希尔排序");
        for(int i =0;i<result3.length;i++){
            System.out.print(" "+ result3[i]);
        }
        System.out.print("\n冒泡排序");
        for(int i =0;i<result4.length;i++){
            System.out.print(" "+ result4[i]);
        }
        System.out.print("\n快速排序");
        for(int i =0;i<result5.length;i++){
            System.out.print(" "+ result5[i]);
        }
        System.out.print("\n归并排序");
        for(int i =0;i<result6.length;i++){
            System.out.print(" "+ result6[i]);
        }
    }
}
