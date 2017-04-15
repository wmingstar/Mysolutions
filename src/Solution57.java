/**
 * Created by byuwa on 2017/4/1.
 *
 * 在一个排序的链表中，如何删除重复的结点
 */
public class Solution57 {
    public static Node deleteDuplicateNode(Node head){
        if (head == null) {
            return null;
        }

//        // 只有一个结点
//        if (head.next == null) {
//            return head;
//        }

        // 临时的头结点
        Node root = new Node();
        root.next = head;
        // 记录前驱结点
        Node prev = root;
        // 记录当前处理的结点
        Node cur_node = head;
        while (cur_node != null && cur_node.next != null) {
            // 有重复结点，与node值相同的结点都要删除
            if (cur_node.value == cur_node.next.value) {
                // 找到下一个不同值的节点，注意其有可能也是重复节点
                while (cur_node.next != null && cur_node.next.value == cur_node.value) {
                    cur_node = cur_node.next;
                }
                // 指向下一个节点，prev.next也可能是重复结点
                // 所以prev不要移动到下一个结点
                prev.next = cur_node.next;
            }
            // 相邻两个值不同，说明node不可删除，要保留
            else {
                prev.next = cur_node;
                prev = prev.next;

            }
            cur_node = cur_node.next;
        }

        return root.next;
    }
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
        test06();
        test07();
        test08();
        test09();
        test10();
    }

    // 1->2->3->3->4->4->5
    private static void test01() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        Node n5 = new Node(4);
        Node n6 = new Node(4);
        Node n7 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println("test1");
        Node result = deleteDuplicateNode(n1);
        printListNode(result);
    }

    // 1->2->3->4->5->6->7
    private static void test02() {
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
        n5.next = n6;
        n6.next = n7;

        System.out.println("test2");
        Node result = deleteDuplicateNode(n1);
        printListNode(result);
    }

    // 1->1->1->1->1->1->2
    private static void test03() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println("test3");
        Node result = deleteDuplicateNode(n1);
        printListNode(result);
    }


    // 1->1->1->1->1->1->1
    private static void test04() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println("test4");
        Node result = deleteDuplicateNode(n1);
        printListNode(result);
    }

    // 1->1->2->2->3->3->4->4
    private static void test05() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(3);
        Node n6 = new Node(3);
        Node n7 = new Node(4);
        Node n8 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        System.out.println("test5");
        Node result = deleteDuplicateNode(n1);
        printListNode(result);
    }

    // 1->1->2->3->3->4->5->5
    private static void test06() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(3);
        Node n6 = new Node(4);
        Node n7 = new Node(5);
        Node n8 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        System.out.println("test6");
        Node result = deleteDuplicateNode(n1);
        printListNode(result);
    }

    // 1->1->2->2->3->3->4->5->5
    private static void test07() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(3);
        Node n6 = new Node(3);
        Node n7 = new Node(4);
        Node n8 = new Node(5);
        Node n9 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        System.out.println("test7");
        Node result = deleteDuplicateNode(n1);
        printListNode(result);
    }

    // 1->2
    private static void test08() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        n1.next = n2;

        System.out.println("test8");
        Node result = deleteDuplicateNode(n1);
        printListNode(result);
    }

    // 1
    private static void test09() {
        Node n1 = new Node(1);
        System.out.println("test9");
        Node result = deleteDuplicateNode(n1);
        printListNode(result);
    }

    // null
    private static void test10() {
        System.out.println("test10");
        Node result = deleteDuplicateNode(null);
        printListNode(result);
    }

    public static void printListNode(Node head){
        if(head==null){
            System.out.print(" 链表为空");
        }
        while (head!=null){
            System.out.print(" "+head.value);
            head = head.next;
        }
        System.out.print("\n");
    }


}
