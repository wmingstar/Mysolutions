import java.util.Stack;

/**
 * Created by byuwa on 2017/3/19.
 * 两个栈实现队列
 */
public class SQueue {
    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();
    public void add(int data){
        stack1.add(data);
    }

    public int pop(){
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.add(stack1.pop());
            }
        }
        if(stack2.empty()){
            throw new RuntimeException("队列为空");
        }
        int result = stack2.pop();
        return result;
    }

    public static void main(String[] args) throws Exception {
        SQueue queue = new SQueue();
        //入队操作
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        //出队操作
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}
