/**
 * Created by byuwa on 2017/3/25.
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 *
 */
public class Solution17 {
    //法1 非递归实现
    public Node mergeList1(Node head1,Node head2){
        if(head1==null && head2==null){
            return null;
        }
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        Node head;
        if(head1.value<=head2.value){
            head = head1;
            head1 = head1.next;
        }
        else {
            head = head2;
            head2 = head2.next;
        }
        Node cur_node = head;
        while (head1!=null && head2!=null){
            if(head1.value<=head2.value){
                cur_node.next = head1;
                head1 = head1.next;
            }
            else {
                cur_node.next = head2;
                head2=head2.next;
            }
            cur_node = cur_node.next;
        }
        while(head1!=null){
            cur_node.next = head1;
            head1 = head1.next;
            cur_node = cur_node.next;
        }
        while (head2!=null){
            cur_node.next = head2;
            head2 = head2.next;
            cur_node = cur_node.next;
        }
        cur_node.next=null;
        return head;
    }

    //法2 递归实现
    public Node mergeList2(Node head1,Node head2){
        if(head1==null){
            return head2;
        }
        else if(head2==null){
            return head1;
        }
        Node head;
        if(head1.value<head2.value){
            head = head1;
            head.next = mergeList2(head1.next,head2);
        }
        else{
            head = head2;
            head.next = mergeList2(head1,head2.next);
        }
        return head;
    }

    public static void main(String[] args){
        Node head1 = new Node(2);
        head1.next = new Node(8);
        head1.next.next = new Node(10);
        head1.next.next.next = new Node(20);

        Node head2= new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(7);
        head2.next.next.next = new Node(18);

        Solution17 s17 = new Solution17();



        Node new_head = s17.mergeList1(head1,head2);
        while (new_head!=null){
            System.out.format("   %d",new_head.value);
            new_head = new_head.next;
        }
    }
}
