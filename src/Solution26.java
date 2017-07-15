import java.util.HashMap;
import java.util.Map;

/**
 * Created by byuwa on 2017/4/7.
 *
 * 请实现函数，使其可以复制一个复杂链表。
 * 在复杂链表中，每个结点除了有一个 m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任意
 * 结点或者 null.
 *
 */
public class Solution26 {

     // 复杂链表结点
    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    //借助 额外空间
    public static ComplexListNode clone2(ComplexListNode head){
        if(head==null){
            return null;
        }
        ComplexListNode head1=head;
        ComplexListNode head2=head;
        ComplexListNode new_head = new ComplexListNode();
        ComplexListNode new_head1 = new_head;
        ComplexListNode new_head2 = new_head;
        ComplexListNode temp = new_head;
        while (head!=null){
            temp.value = head.value;
            head = head.next;
            if(head!=null) {
                temp.next = new ComplexListNode();
                temp = temp.next;
            }
        }
        Map<ComplexListNode,ComplexListNode> node_map = new HashMap<>();
        while (head1!=null){
            node_map.put(head1,new_head1);
            head1=head1.next;
            new_head1=new_head1.next;
        }
        while (head2!=null){
            if(head2.sibling!=null){
                new_head2.sibling = node_map.get(head2.sibling);
            }
            head2 = head2.next;
            new_head2=new_head2.next;
        }
        return new_head;

    }


    /**
     * @param head 链表表头结点
     * @return 复制结点的头结点
     */
    public static ComplexListNode clone(ComplexListNode head) {
        // 如果链表为空就直接返回空
        if (head == null) {
            return null;
        }

        // 先复制结点
        cloneNodes(head);
        // 再链接sibling字段
        connectNodes(head);
        // 将整个链表拆分，返回复制链表的头结点
        return reconnectNodes(head);
    }

    /**
     * 复制链表，将复制后的结点插入到被复制的结点后面
     * @param head 待复制链表的头结点
     */
    public static void cloneNodes(ComplexListNode head) {
        // 如果链表不空，进行复制操作
        while (head != null) {
            // 创建一个新的结点
            ComplexListNode tmp = new ComplexListNode();
            // 将被复制结点的值传给复制结点
            //  tmp.value = head.value;
            ///////////////////////////////////////////////////////////////////////////////////////////
            // TODO 此处为了做测试，让复制结点的值都增加了100，如果不需要可以将下面一行注释掉，打开上一行。
            tmp.value = head.value + 100;
            ///////////////////////////////////////////////////////////////////////////////////////////

            // 复制结点的next指向下一个要被复制的结点
            tmp.next = head.next;
            // 被复制结点的next指向复制结点
            head.next = tmp;
            // 到些处就已经完成了一个结点的复制并且插入到被复制结点的后面
            // heed指向下一个被复制结点的位置
            head = tmp.next;
        }
    }

    /**
     * 复制结点的sibling字段
     * @param head 链表的头结
     */
    public static void connectNodes(ComplexListNode head) {
        // 如链表不为空
        while (head != null) {
            // 当前处理的结点sibling字段不为空，则要设置其复制结点的sibling字段
            if (head.sibling != null) {
                // 复制结点的sibling指向被复制结点的sibling字段的下一个结点
                // head.next：表求复制结点，
                // head.sibling：表示被复制结点的sibling所指向的结点，
                // 它的下一个结点就是它的复制结点
                head.next.sibling = head.sibling.next;
            }
            // 指向下一个要处理的复制结点
            head = head.next.next;
        }
    }

    /**
     * 将复制结点和被复制结点拆开，还原被复制的链表
     * @param head 链表的头结点
     * @return 复制链表的头结点
     */
    public static ComplexListNode reconnectNodes(ComplexListNode head) {

        // 当链表为空就直接返回空
        if (head == null) {
            return null;
        }
        // 用于记录复制链表的头结点
        ComplexListNode newHead = head.next;
        // 用于记录当前处理的复制结点
        ComplexListNode pointer = newHead;
        // 被复制结点的next指向下一个被复制结点
        head.next = newHead.next;
        // 指向新的被复制结点
        head = head.next;

        while (head != null) {
            // pointer指向复制结点
            pointer.next = head.next;
            pointer = pointer.next;
            // head的下一个指向复制结点的下一个结点，即原来链表的结点
            head.next = pointer.next;
            // head指向下一个原来链表上的结点
            head = head.next;
        }
        // 返回复制链表的头结点
        return newHead;
    }

    /**
     * 输出链表信息
     *
     * @param head 链表头结点
     */
    public static void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    /**
     * 判断两个链表是否是同一个链表，不是值相同
     * @param h1 链表头1
     * @param h2 链表头2
     * @return true：两个链表是同一个链表，false：不是
     */
    public static boolean isSame(ComplexListNode h1, ComplexListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return false;
            }
        }
        return h1 == null && h2 == null;
    }

    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        ComplexListNode head = new ComplexListNode();
        head.value = 1;
        head.next = new ComplexListNode();
        head.next.value = 2;
        head.next.next = new ComplexListNode();
        head.next.next.value = 3;
        head.next.next.next = new ComplexListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ComplexListNode();
        head.next.next.next.next.value = 5;

        head.sibling = head.next.next;
        head.next.sibling = head.next.next.next.next.next;
        head.next.next.next.sibling = head.next;

        ComplexListNode tmp = head;
        System.out.println("原始链表");
        printList(head);
        ComplexListNode newHead = clone(head);
        System.out.println();
        System.out.println("克隆之后，再次输出原始链表，检测原始链表的结构在克隆" +
                "过程中是否发生变化");
        printList(head);
        System.out.println("判断克隆之后原链表结构是否改变");
        System.out.println(isSame(head, tmp));
        System.out.println("克隆得到的链表");
        printList(newHead);
        System.out.println("判断原链表与克隆得到的链表是否相等");
        System.out.println(isSame(head, newHead));


        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        ComplexListNode head2 = new ComplexListNode();
        head2.value = 1;
        head2.next = new ComplexListNode();
        head2.next.value = 2;
        head2.next.next = new ComplexListNode();
        head2.next.next.value = 3;
        head2.next.next.next = new ComplexListNode();
        head2.next.next.next.value = 4;
        head2.next.next.next.next = new ComplexListNode();
        head2.next.next.next.next.value = 5;

        head2.next.sibling = head2.next.next.next.next;
        head2.next.next.next.sibling = head2.next.sibling;
        head2.next.next.sibling = head2.next.next;

        System.out.println("\n");
        tmp = head2;
        System.out.println("输出原始链表");
        printList(head2);
        ComplexListNode newHead2 = clone(head2);
        System.out.println("克隆之后，再次输出原始链表，检测原始链表的结构在克隆" +
                "过程中是否发生变化");
        printList(head2);
        System.out.println("判断克隆之后原链表结构是否改变");
        System.out.println(isSame(head2, tmp));
        System.out.println("克隆得到的链表");
        printList(newHead2);
        System.out.println("判断原链表与克隆得到的链表是否相等");
        System.out.println(isSame(head2, newHead2));


        ComplexListNode head3 = new ComplexListNode();
        head3.value = 1;

        System.out.println("\n");
        tmp = head3;
        System.out.println("输出原始链表");
        printList(head3);
        ComplexListNode newHead3 = clone(head3);
        System.out.println("克隆之后，再次输出原始链表，检测原始链表的结构在克隆" +
                "过程中是否发生变化");
        printList(head3);
        System.out.println("判断克隆之后原链表结构是否改变");
        System.out.println(isSame(head3, tmp));
        System.out.println("克隆得到的链表");
        printList(newHead3);
        System.out.println("判断原链表与克隆得到的链表是否相等");
        System.out.println(isSame(head3, newHead3));

    }
}
