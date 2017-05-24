import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by byuwa on 2017/3/19.
 *
 * 用队列实现栈
 */
public class QStack {
    private Queue<Integer> queue1=new ArrayDeque();
    private Queue<Integer> queue2=new ArrayDeque();

    public void push(int data){
        if(queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(data);
        }
        else if(queue1.isEmpty() && !queue2.isEmpty()){
            queue2.add(data);
        }
       else if(!queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(data);
        }
    }

    public int pop(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int result = 0;
        if(queue1.isEmpty() && !queue2.isEmpty()) {
            while (!queue2.isEmpty()) {
                result = queue2.poll();
                if (!queue2.isEmpty()) {
                    queue1.add(result);
                }
            }
        }
        else if (!queue1.isEmpty() && queue2.isEmpty()) {
                while (!queue1.isEmpty()) {
                    result = queue1.poll();
                    if (!queue1.isEmpty()) {
                        queue2.add(result);
                    }
                }
            }
        return result;
        }
    public static void main(String[] args) throws Exception {
        QStack stack = new QStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
    }

}
