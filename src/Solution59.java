import java.util.ArrayList;

/**
 * Created by byuwa on 2017/4/3.
 *请实现一个函数来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * (题目19  求二叉树的镜像)
 *
 * 思路：得到树的镜像，遍历 树 和 它的镜像，对比每个结点是否相等
 *
 */
public class Solution59 {

    public static boolean isSymmetrical2(BinaryTreeNode root) {
        return isSymmetrical2(root, root);
    }

    private static boolean isSymmetrical2(BinaryTreeNode left, BinaryTreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.value != right.value) {
            return false;
        }

        return isSymmetrical2(left.left, right.right) && isSymmetrical2(left.right, right.left);
    }

    public static boolean isSymmetrical(BinaryTreeNode root){
        if(root==null){
            System.out.print("空树");
        }
        ArrayList node_list1 = new ArrayList();
        //遍历树，将树各结点值存入list
        traversal(node_list1,root);
        //求树的镜像
        mirrorTree(root);
        ArrayList node_list2 = new ArrayList();
        traversal(node_list2,root);
        boolean result = compareList(node_list1,node_list2);
        return result;
    }

    public static void traversal(ArrayList node_list,BinaryTreeNode root){
        if(root==null){
            return;
        }
        node_list.add(root.value);
        traversal(node_list,root.left);
        traversal(node_list,root.right);
    }

    public static void mirrorTree(BinaryTreeNode root){
        if(root==null){
            return;
        }
        BinaryTreeNode temp =root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    public static boolean compareList(ArrayList list1,ArrayList list2){
        if(list1.size()!=list2.size()){
            return false;
        }
        int temp1=0;
        int temp2=0;
        for(int i=0;i<list1.size();i++){
            temp1=(int)list1.get(i);
            temp2=(int)list2.get(i);
            if(temp1!=temp2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test01();
        test02();
    }

    private static void assemble(BinaryTreeNode node,
                                 BinaryTreeNode left,
                                 BinaryTreeNode right) {
        node.left = left;
        node.right = right;
    }

    //                            1
    //                  2                   2
    //             4         6          6          4
    //          8     9   10   11   11     10   9     8
    public static void test01() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(2);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(6);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(4);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n11 = new BinaryTreeNode(11);
        BinaryTreeNode n12 = new BinaryTreeNode(11);
        BinaryTreeNode n13 = new BinaryTreeNode(10);
        BinaryTreeNode n14 = new BinaryTreeNode(9);
        BinaryTreeNode n15 = new BinaryTreeNode(8);

        assemble(n1, n2, n3);
        assemble(n2, n4, n5);
        assemble(n3, n6, n7);
        assemble(n4, n8, n9);
        assemble(n5, n10, n11);
        assemble(n6, n12, n13);
        assemble(n7, n14, n15);
        assemble(n8, null, null);
        assemble(n9, null, null);
        assemble(n10, null, null);
        assemble(n11, null, null);
        assemble(n12, null, null);
        assemble(n13, null, null);
        assemble(n14, null, null);
        assemble(n15, null, null);

        System.out.println(isSymmetrical(n1));

    }


    //                            1
    //                  2                   2
    //             4         5          6          4
    //          8     9   10   11   11     10   9     8
    public static void test02() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(2);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(4);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n11 = new BinaryTreeNode(11);
        BinaryTreeNode n12 = new BinaryTreeNode(11);
        BinaryTreeNode n13 = new BinaryTreeNode(10);
        BinaryTreeNode n14 = new BinaryTreeNode(9);
        BinaryTreeNode n15 = new BinaryTreeNode(8);

        assemble(n1, n2, n3);
        assemble(n2, n4, n5);
        assemble(n3, n6, n7);
        assemble(n4, n8, n9);
        assemble(n5, n10, n11);
        assemble(n6, n12, n13);
        assemble(n7, n14, n15);
        assemble(n8, null, null);
        assemble(n9, null, null);
        assemble(n10, null, null);
        assemble(n11, null, null);
        assemble(n12, null, null);
        assemble(n13, null, null);
        assemble(n14, null, null);
        assemble(n15, null, null);

        System.out.println(isSymmetrical(n1));

    }




}

