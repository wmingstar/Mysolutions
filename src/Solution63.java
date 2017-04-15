import java.util.LinkedList;
import java.util.List;

/**
 * Created by byuwa on 2017/4/6.
 *
 * 给定一颗二叉搜索树，找出其中第 K 大的结点。
 *
 */
public class Solution63 {
    public static BinaryTreeNode kthNode(BinaryTreeNode root,int k){
        if(root==null || k<1){
            return null;
        }
        List<BinaryTreeNode> tree_list = new LinkedList<>();
        traversal(root,tree_list);
        if(k>tree_list.size()){
            return null;
        }
        BinaryTreeNode result = tree_list.get(k-1);
        return result;
    }

    public static void traversal(BinaryTreeNode root,List<BinaryTreeNode> tree_list){
        if(root==null){
            return;
        }
        traversal(root.left,tree_list);
        tree_list.add(root);
        traversal(root.right,tree_list);
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(5);
        BinaryTreeNode n2 = new BinaryTreeNode(3);
        BinaryTreeNode n3 = new BinaryTreeNode(7);
        BinaryTreeNode n4 = new BinaryTreeNode(2);
        BinaryTreeNode n5 = new BinaryTreeNode(4);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(8);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;


        printTree(n1);
        System.out.println();

        for (int i = 0; i <= 10; i++) {
             BinaryTreeNode result = kthNode(n1,i);
             if(result!=null){
                 System.out.printf("%-3d", result.value);
             }
        }

    }
    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.printf("%-3d", root.value);
            printTree(root.right);
        }
    }

}


