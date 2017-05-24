import java.util.Stack;

/**
 * Created by byuwa on 2017/3/20.
 *
 * 输入一个链表的头节点，从头到尾反过来打印出每个节点的值
 */
public class Solution5 {
    //
    public static void printListReversinglyUsingStack(Node head){
        if(head==null){
            return;
        }
        Stack<Node> stack = new Stack();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().value+" ");
        }
    }

    //递归实现
    public static void printListInverselyUsingRecursion(Node head) {
        if (head == null) {
            return;
        }
        printListInverselyUsingRecursion(head.next);
        System.out.print(head.value + " ");
    }


    public static void main(String[] args){
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println("通过栈 实现");
        Solution5.printListReversinglyUsingStack(head);
        System.out.print("\n");
        System.out.println("通过递归实现");
        Solution5.printListInverselyUsingRecursion(head);
    }
}
