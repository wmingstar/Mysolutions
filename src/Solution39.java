/**
 * Created by byuwa on 2017/3/30.
 * 输入一颗二叉树的根节点，求该树的深度，从根结点到叶节点依次经过的结点（含 根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * 输入一颗二叉树，判断该树 是不是平衡树
 *
 */
public class Solution39 {
    // 求树的深度
    public static int treeDepth(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left>right?(left+1):(right+1);
    }

    //判断是否是平衡树
    public static boolean isBalanced1(BinaryTreeNode root){
        if(root==null){
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left-right;
        if(diff>1 || diff<-1){
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    public static boolean isBalanced2(BinaryTreeNode root){
        if(root == null){
            return true;
        }
        int[] depth = new int[1];
        return balanceHelper(root,depth);

    }
    private static boolean balanceHelper(BinaryTreeNode root,int[] depth){
        if(root==null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if(balanceHelper(root.left,left) && balanceHelper(root.right,right)){
            int diff = left[0]-right[0];
            if(diff<=1 && diff>=-1){
                depth[0] = 1+(left[0]>right[0]?left[0]:right[0]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }


    // 完全二叉树
    //             1
    //         /      \
    //        2        3
    //       /\       / \
    //      4  5     6   7
    private static void test1() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(1);
        BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(isBalanced1(n1));
        System.out.println(isBalanced2(n1));
        System.out.println("----------------");

    }

    // 不是完全二叉树，但是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    private static void test2() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(1);
        BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n3.right = n6;


        System.out.println(isBalanced1(n1));
        System.out.println(isBalanced2(n1));
        System.out.println("----------------");
    }

    // 不是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\
    //      4  5
    //        /
    //       7
    private static void test3() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(1);
        BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;

        System.out.println(isBalanced1(n1));
        System.out.println(isBalanced2(n1));
        System.out.println("----------------");
    }

    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test4() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(1);
        BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(1);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;


        System.out.println(isBalanced1(n1));
        System.out.println(isBalanced2(n1));
        System.out.println("----------------");
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test5() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(1);
        BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(1);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;


        System.out.println(isBalanced1(n1));
        System.out.println(isBalanced2(n1));
        System.out.println("----------------");
    }


}
