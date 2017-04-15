import java.util.Stack;

/**
 * Created by byuwa on 2017/3/25.
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设栈的所有数字均不相等
 */
public class Solution22 {
   public static boolean isPopOrder(int[] push,int[] pop){
       boolean result = false;

       if(push!=null && pop!=null && push.length==pop.length){
           int push_index = 0;
           int pop_index = 0;
           Stack<Integer> stack = new Stack();
           while (pop_index<pop.length ){
               while (stack.isEmpty() || stack.peek()!=pop[pop_index]){
                   if(push_index>=push.length){
                       break;
                   }
                   stack.push(push[push_index]);
                   push_index++;
               }

               if (stack.peek()!=pop[pop_index]){
                   break;
               }
               stack.pop();
               pop_index++;

           }
           if(stack.isEmpty()){
               result = true;
           }
       }
       return result;
   }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};
        int[] push5 = {1};
        int[] pop5 = {2};
        int[] push6 = {1};
        int[] pop6 = {1};


        // 测试方法
        System.out.println();
        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));
        System.out.println("false: " + isPopOrder(push5, pop5));
        System.out.println("true: " + isPopOrder(push6, pop6));
        System.out.println("false: " + isPopOrder(null, null));
    }


}
