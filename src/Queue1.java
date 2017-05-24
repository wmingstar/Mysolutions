/**
 * Created by byuwa on 2017/3/19.
 *
 * 用链表实现队列
 */
public class Queue1 {
    Node head;
    Node current;
    public void add(int data){
        if(head==null){
            head = new Node(data);
            current=head;
        }
        else{
            current.next=new Node(data);
            current=current.next;
        }
    }

    public  int pop(){
        if(current==null){
            throw new RuntimeException("队列为空");
        }
        Node result=head;
        head=head.next;
        return result.value;
    }

    public static void main(String[] args) throws Exception {
        Queue1 queue = new Queue1();
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
