import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by byuwa on 2017/4/6.
 *
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值
 *
 */
public class Solution65 {
    private static List<Integer> maxInWindows(List<Integer> data, int size) {
        List<Integer> windowMax = new LinkedList<>();

        // 条件检查
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }

        Deque<Integer> idx = new LinkedList<>();

        // 窗口还没有被填满时，找最大值的索引
        for (int i = 0; i < size && i < data.size(); i++) {
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }

            //  添加索引
            idx.addLast(i);
        }

        // 窗口已经被填满了
        for (int i = size; i < data.size(); i++) {
            // 第一个窗口的最大值保存
            windowMax.add(data.get(idx.getFirst()));

            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }

            // 删除已经滑出窗口的数据对应的下标
            if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
                idx.removeFirst();
            }

            // 可能的最大的下标索引入队
            idx.addLast(i);
        }

        // 最后一个窗口最大值入队
        windowMax.add(data.get(idx.getFirst()));

        return windowMax;

    }

    private static List<Integer> maxInWindows2(List<Integer> data, int size) {
        List<Integer> windowMax = new LinkedList<>();

        // 条件检查
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }

        int index1 = 0;
        int index2 = index1+size-1;
        if(index2>=data.size()){
            windowMax.add(getMax(data,0,data.size()-1));
            return windowMax;
        }
        for(;index2<data.size();){
            windowMax.add(getMax(data,index1,index2));
            index1++;
            index2 =index1+size-1;
        }
        return windowMax;
    }

    private static int getMax(List<Integer> data,int start,int end){
        int max =data.get(start);
        for(int i=start+1;i<=end;i++){
            if(data.get(i)>max){
                max = data.get(i);
            }
        }
        return max;
    }

    private static List<Integer> arrayToCollection(int[] array) {
        List<Integer> result = new LinkedList<>();
        if (array != null) {
            for (int i : array) {
                result.add(i);
            }
        }

        return result;
    }
    public static void main(String[] args) {

        // expected {7};
        List<Integer> data1 = arrayToCollection(new int[]{1, 3, -1, -3, 5, 3, 6, 7});
        System.out.println(data1 + "," + maxInWindows(data1, 10));

        // expected {3, 3, 5, 5, 6, 7};
        List<Integer> data2 = arrayToCollection(new int[]{1, 3, -1, -3, 5, 3, 6, 7});
        System.out.println(data2 + "," + maxInWindows(data2, 3));

        // expected {7, 9, 11, 13, 15};
        List<Integer> data3 = arrayToCollection(new int[]{1, 3, 5, 7, 9, 11, 13, 15});
        System.out.println(data3 + "," + maxInWindows(data3, 4));

        // expected  {16, 14, 12};
        List<Integer> data5 = arrayToCollection(new int[]{16, 14, 12, 10, 8, 6, 4});
        System.out.println(data5 + "," + maxInWindows(data5, 5));

        // expected  {10, 14, 12, 11};
        List<Integer> data6 = arrayToCollection(new int[]{10, 14, 12, 11});
        System.out.println(data6 + "," + maxInWindows(data6, 1));

        // expected  {14};
        List<Integer> data7 = arrayToCollection(new int[]{10, 14, 12, 11});
        System.out.println(data7 + "," + maxInWindows(data7, 4));

        //****************************************************
        List<Integer> data8 = arrayToCollection(new int[]{1, 3, -1, -3, 5, 3, 6, 7});
        System.out.println(data8+ "," + maxInWindows2(data8, 10));

        // expected {3, 3, 5, 5, 6, 7};
        List<Integer> data9 = arrayToCollection(new int[]{1, 3, -1, -3, 5, 3, 6, 7});
        System.out.println(data9 + "," + maxInWindows2(data9, 3));

        // expected {7, 9, 11, 13, 15};
        List<Integer> data10 = arrayToCollection(new int[]{1, 3, 5, 7, 9, 11, 13, 15});
        System.out.println(data10 + "," + maxInWindows2(data10, 4));

        // expected  {16, 14, 12};
        List<Integer> data11 = arrayToCollection(new int[]{16, 14, 12, 10, 8, 6, 4});
        System.out.println(data11 + "," + maxInWindows2(data11, 5));

        // expected  {10, 14, 12, 11};
        List<Integer> data12 = arrayToCollection(new int[]{10, 14, 12, 11});
        System.out.println(data12 + "," + maxInWindows2(data12, 1));

        // expected  {14};
        List<Integer> data13 = arrayToCollection(new int[]{10, 14, 12, 11});
        System.out.println(data13 + "," + maxInWindows2(data13, 4));
    }


}
