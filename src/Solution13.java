/**
 * Created by byuwa on 2017/3/24.
 * 给定单项链表的头指针和一个结点指针，定义一个函数在O（1） 时间删除该结点
 *
 */
public class Solution13 {
    public Node deleteNode(Node head,Node tobedelete){
        if(head == null || tobedelete == null){
            return null;
        }
        if(head == tobedelete ){
            return head.next;
        }
        if(tobedelete.next==null){
            Node temp = head;
            while(temp.next!=tobedelete){
                temp = temp.next;
            }
            temp.next = null;
        }

        else{
            Node temp = tobedelete.next;
            tobedelete.value = temp.value;
            tobedelete.next = temp.next;
        }
        return head;
    }

}
