/**
 * Created by byuwa on 2017/3/27.
 * 输入一颗二叉搜索树，将其转换为一个排序的双向链表。
 */
public class Solution27 {

    public static BinaryTreeNode convert(BinaryTreeNode root){
        if(root == null){
            return null;
        }
        BinaryTreeNode[] last_node = new BinaryTreeNode[1];
        convertTree(root,last_node);
        BinaryTreeNode head = last_node[0];
        while (head!=null && head.left!=null){
            head=head.left;
        }
        return head;
    }

    public static void convertTree(BinaryTreeNode root,BinaryTreeNode[] last_node){
        if(root!=null){
            if(root.left!=null){
                convertTree(root.left,last_node);
            }
            root.left = last_node[0];
            if(last_node[0]!=null){
                last_node[0].right = root;
            }
            last_node[0] = root;
            if(root.right!=null){
                convertTree(root.right,last_node);
            }
        }
    }
    public static void main(String[] args) {
        test01();
    }

    private static void printList(BinaryTreeNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.right;
        }

        System.out.println("null");
    }

    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + "->");
            printTree(root.right);
        }
    }


    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.value = 10;

        BinaryTreeNode node6 = new BinaryTreeNode();
        node6.value = 6;

        BinaryTreeNode node14 = new BinaryTreeNode();
        node14.value = 14;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node8 = new BinaryTreeNode();
        node8.value = 8;

        BinaryTreeNode node12 = new BinaryTreeNode();
        node12.value = 12;

        BinaryTreeNode node16 = new BinaryTreeNode();
        node16.value = 16;

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        BinaryTreeNode head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();

    }
}
