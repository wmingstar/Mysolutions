import java.util.Stack;

/**
 * Created by byuwa on 2017/3/24.
 *
 * 反转链表，实现一个函数，输入一个链表的头节点，反转该链表，输出反转后链表的头节点
 */
public class Solution16 {
    public Node reverseList(Node head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        Node reverse_head = null;
        Node cur_node = head;
        Node pre_node = null;
        Node next_node;
        while (cur_node!=null){
            next_node = cur_node.next;
            if(next_node == null){
                reverse_head = cur_node;
            }
            cur_node.next = pre_node;
            pre_node = cur_node;
            cur_node = next_node;
        }
        return reverse_head;
    }

    public static Node reverseList2(Node head){
        if(head == null){
            return null;
        }
        if(head.next ==null){
            return head;
        }
        Stack<Node> temp = new Stack<>();
        while (head!=null){
            temp.add(head);
            head=head.next;
        }
        Node reverse_node = temp.pop();
        Node cur_node = reverse_node;
        while (!temp.empty()){
           cur_node.next=temp.pop();
           cur_node=cur_node.next;
        }
        cur_node.next=null;
        return reverse_node;
    }

    public static void main(String[] args){
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        Solution16 s16 = new Solution16();
        Node re_head = s16.reverseList(head);
        while (re_head!=null){
            System.out.print(re_head.value);
            re_head = re_head.next;
        }
    }

}
