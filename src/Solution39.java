/**
 * Created by byuwa on 2017/3/30.
 * 输入一颗二叉树的根节点，求该树的深度，从根结点到叶节点依次经过的结点（含 根、叶结点）形成姝的一条路径，
 * 最长路径的长度为树的深度。
 *
 * shrubs一颗二叉树，判断该树 是不是平衡树
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
            System.out.print("空树");
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left-right;
        if(diff>1 && diff<-1){
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


}
