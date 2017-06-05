/**
 * Created by byuwa on 2017/3/24.
 * 给定单项链表的头指针和一个结点指针，定义一个函数在O（1） 时间删除该结点
 *
 */
public class Solution13 {

    public static Node deleteNode(Node head, Node toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return head;
        }

        if (head == toBeDeleted) {
            return head.next;
        }

        Node temp = head;
        boolean flag = judge(temp,toBeDeleted);
        if(!flag){
            System.out.println("待删除的结点不在链表当中");
            return head;
        }
        // 下面的情况链表至少有两个结点
        // 在多个节点的情况下，如果删除的是最后一个元素
        if (toBeDeleted.next == null) {
            // 找待删除元素的前驱
            Node tmp = head;
            while (tmp.next != toBeDeleted) {
                tmp = tmp.next;
            }
            // 删除结点
            tmp.next = null;

        }
        // 在多个节点的情况下，如果删除的是某个中间结点
        else {
            temp = toBeDeleted.next;
            toBeDeleted.value = temp.value;
            // 待删除的结点的下一个指向原先待删除引号的下下个结点，即将待删除的下一个结点删除
            toBeDeleted.next = temp.next;
        }
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static boolean judge(Node head,Node toBeDeleted){
        boolean flag = false;
        while (head!=null){
            if(head==toBeDeleted){
                flag=true;
            }
            head=head.next;
        }
        return flag;

    }
    public static void main(String[] args) {


        Node head = new Node();
        head.value = 1;

        head.next = new Node();
        head.next.value = 2;

        head.next.next = new Node();
        head.next.next.value = 3;

        head.next.next.next = new Node();
        head.next.next.next.value = 4;

        Node middle = head.next.next.next.next = new Node();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new Node();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.value = 8;

        Node last = head.next.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = deleteNode(head, null); // 删除的结点为空
        printList(head);

        head = deleteNode(head, head); // 删除头结点
        printList(head);
        head = deleteNode(head, last); // 删除尾结点
        printList(head);
        head = deleteNode(head, middle); // 删除中间结点
        printList(head);

        // 若待删除的结点并不在链表当中时，则会报错，解决的方法是增加一个方法，用于判断
        //待删除的结点是否在链表中
        Node node = new Node();
        node.value =12;
        head = deleteNode(head,node);
        printList(head);


    }

}
