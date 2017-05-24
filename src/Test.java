import java.util.ArrayDeque;
import java.util.Queue;

public class Test {
    private Queue<Integer> queue1 = new ArrayDeque();
    private Queue<Integer> queue2 = new ArrayDeque();
    public void push(int data){
        if(queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(data);
        }
        else if(!queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(data);
        }
        else if(queue1.isEmpty() && !queue2.isEmpty()){
            queue2.add(data);
        }
        else {
            return;
        }

    }

    public int pop(){
        int result=0;
        if(queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        if(queue1.isEmpty() && !queue2.isEmpty()){
            while (!queue2.isEmpty()){
                result = queue2.poll();
                if(!queue2.isEmpty()){
                    queue1.add(result);
                }
            }
        }
    }


}