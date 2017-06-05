import java.util.Stack;

/**
 * Created by byuwa on 2017/4/7.
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min函数，在该栈中
 * 调用 min  push  pop 的时间复杂度都是 O(1)
 */
public class Solution21 {
    private  Stack<Integer> dataStack;
    private  Stack<Integer> minStack;
    // 构造函数
    public Solution21() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }
    public void push(int num){
        if(this.minStack.size()==0){
            this.minStack.push(num);
        }
        else {
            if(this.minStack.peek()>num){
                this.minStack.push(num);
            }
            else {
                this.minStack.push(this.minStack.peek());
            }
        }
        this.dataStack.push(num);
    }

    public int pop(){
        if(this.dataStack.size()<1){
            System.out.print("栈为空");
            return -1;
        }
        int result = this.dataStack.pop();
        this.minStack.pop();
        return result;
    }

    public int min(){
        if(this.minStack.size()<1){
            System.out.print("栈为空");
            return -1;
        }
        return this.minStack.peek();
    }
    public static void main(String[] args) {
        Solution21 stack = new Solution21();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }



}
