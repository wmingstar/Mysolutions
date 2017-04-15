/**
 * Created by byuwa on 2017/3/24.
 *
 *输入一个链表，输出该链表中倒数第K个结点
 */
public class Solution15 {
    public Node findKthToTail(Node head,int k){
        if(head==null){
            throw new RuntimeException("链表为空");
        }
        if(k<0){
            throw new RuntimeException("K 小于 0 ");
        }

        Node quick = head;
        Node slow = head;
        int i = 0;
        while (i<k){
            quick = quick.next;
            i++;
        }
        while (quick!=null){
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args){
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        Solution15 s15 = new Solution15();
        Node result = s15.findKthToTail(head,1);
        System.out.print(result.value);
    }

}
