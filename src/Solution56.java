/**
 * Created by byuwa on 2017/4/1.
 * 一个链表中包含环，如何找出环的入口结点。
 *
 */
public class Solution56 {
    public static Node findEntryNode(Node head){
        if(head==null){
            return null;
        }
        Node slow = head;
        Node quick = head;
        boolean flag = false;
        while (quick.next.next!=null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                flag = true;
                System.out.println("有环");
                break;
            }
        }
        if(!flag){
            System.out.println("无环");
            return null;
        }
        slow = head;
        while (slow!=quick){
            slow=slow.next;
            quick=quick.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    // 1->2->3->4->5->6
    private static void test01() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        Node result = findEntryNode(n1);
        if (result != null) {
            System.out.println(result.value);
        }
    }
    // 1->2->3->4->5->6
    //       ^        |
    //       |        |
    //       +--------+
    private static void test02() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        Node result = findEntryNode(n1);
        if (result != null) {
            System.out.println(result.value);
        }
    }

    // 1->2->3->4->5->6 <-+
    //                |   |
    //                +---+
    private static void test03() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n6;

        Node result = findEntryNode(n1);
        if (result != null) {
            System.out.println(result.value);
        }
    }
}
