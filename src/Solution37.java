/**
 * Created by byuwa on 2017/3/30.
 * 输入两个链表，找出它们的第一个公共结点。
 *
 */
public class Solution37 {
    public static Node findCommonNode(Node head1,Node head2){
        if(head1 == null || head2==null){
            return null;
        }
        Node long_list = head1;
        Node short_list = head2;
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        int diff = length1 - length2;
        if(length2>length1){
            long_list = head2;
            short_list = head1;
            diff = length2-length1;
        }
        for(int i=0;i<diff;i++){
            long_list = long_list.next;
        }

        while (long_list!=null && short_list!=null && long_list!=short_list){
            long_list = long_list.next;
            short_list = short_list.next;
        }
        return long_list;
    }
    public static int getLength(Node head){
        Node index = head;
        int length = 0;
        while(index!=null){
            index = index.next;
            length++;
        }
        return length;
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;

        n4.next = n5;
        n5.next = n6;
        Node result = findCommonNode(n1, n4);
        if (result != null) {
            System.out.println(result.value); // 6
        }
    }

    private static void test2() {
        // 没有公共结点
        // 1 - 2 - 3 - 4
        //
        // 5 - 6 - 7
        Node n1 = new  Node(1);
        Node n2 = new  Node(2);
        Node n3 = new  Node(3);
        Node n4 = new  Node(4);
        Node n5 = new  Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n5.next = n6;
        n6.next = n7;
        Node result = findCommonNode(n1, n5);
        if (result != null) {
            System.out.println(result.value); // null
        }

    }

    private static void test3() {
        // 公共结点是最后一个结点
        // 1 - 2 - 3 - 4 \
        //                7
        //         5 - 6 /
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n7;

        n5.next = n6;
        n6.next = n7;
        Node result = findCommonNode(n1, n5);
        if (result != null) {
            System.out.println(result.value);  // 7
        }

    }

    private static void test4() {
        // 公共结点是第一个结点
        // 1 - 2 - 3 - 4 - 5
        // 两个链表完全重合
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Node result = findCommonNode(n1, n1);
        if (result != null) {
            System.out.println(result.value); // 1
        }


    }

}
