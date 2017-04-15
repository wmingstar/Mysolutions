/**
 * Created by byuwa on 2017/4/3.
 *
 * 给定一颗二叉树和其中一个结点，如何找出中序遍历顺序的下一个结点？
 *
 * 树中的结点除了有两个分别指向左右结点的指针外，还有一个指向父结点的指针。
 *
 */
public class Solution58 {
    public static BinaryTreeNode2 getNext(BinaryTreeNode2 node) {
        if (node == null) {
            return null;
        }

        // 保存要查找的下一个节点
        BinaryTreeNode2 target = null;

        if (node.right != null) {
            target = node.right;
            while (target.left != null) {
                target = target.left;
            }

            return target;
        } else if (node.parent != null){
            target = node.parent;
            BinaryTreeNode2 cur = node;
            // 如果父新结点不为空，并且，子结点不是父结点的左孩子
            while (target != null && target.left != cur) {
                cur = target;
                target = target.parent;

            }

            return target;
        }

        return null;
    }

    //构建树
    private static void assemble(BinaryTreeNode2 node,
                                 BinaryTreeNode2 left,
                                 BinaryTreeNode2 right,
                                 BinaryTreeNode2 parent) {
        node.left = left;
        node.right = right;
        node.parent = parent;
    }
    public static void main(String[] args) {
        test01();
    }

    //                            1
    //                  2                   3
    //             4         5          6          7
    //          8     9   10   11   12   13    14   15
    public static void test01() {
        BinaryTreeNode2 n1 = new BinaryTreeNode2(1); // 12
        BinaryTreeNode2 n2 = new BinaryTreeNode2(2); // 10
        BinaryTreeNode2 n3 = new BinaryTreeNode2(3); // 14
        BinaryTreeNode2 n4 = new BinaryTreeNode2(4); // 9
        BinaryTreeNode2 n5 = new BinaryTreeNode2(5); // 11
        BinaryTreeNode2 n6 = new BinaryTreeNode2(6); // 13
        BinaryTreeNode2 n7 = new BinaryTreeNode2(7); // 15
        BinaryTreeNode2 n8 = new BinaryTreeNode2(8); // 4
        BinaryTreeNode2 n9 = new BinaryTreeNode2(9); // 2
        BinaryTreeNode2 n10 = new BinaryTreeNode2(10); // 5
        BinaryTreeNode2 n11 = new BinaryTreeNode2(11); // 1
        BinaryTreeNode2 n12 = new BinaryTreeNode2(12); // 6
        BinaryTreeNode2 n13 = new BinaryTreeNode2(13); // 3
        BinaryTreeNode2 n14 = new BinaryTreeNode2(14); // 7
        BinaryTreeNode2 n15 = new BinaryTreeNode2(15); // null

        assemble(n1, n2, n3, null);
        assemble(n2, n4, n5, n1);
        assemble(n3, n6, n7, n1);
        assemble(n4, n8, n9, n2);
        assemble(n5, n10, n11, n2);
        assemble(n6, n12, n13, n3);
        assemble(n7, n14, n15, n3);
        assemble(n8, null, null, n4);
        assemble(n9, null, null, n4);
        assemble(n10, null, null, n5);
        assemble(n11, null, null, n5);
        assemble(n12, null, null, n6);
        assemble(n13, null, null, n6);
        assemble(n14, null, null, n7);
        assemble(n15, null, null, n7);

        System.out.println(getNext(n1));
        System.out.println(getNext(n2));
        System.out.println(getNext(n3));
        System.out.println(getNext(n4));
        System.out.println(getNext(n5));
        System.out.println(getNext(n6));
        System.out.println(getNext(n7));
        System.out.println(getNext(n8));
        System.out.println(getNext(n9));
        System.out.println(getNext(n10));
        System.out.println(getNext(n11));
        System.out.println(getNext(n12));
        System.out.println(getNext(n13));
        System.out.println(getNext(n14));
        System.out.println(getNext(n15));
    }


}
