/**
 * Created by byuwa on 2017/3/25.
 * 请完成一个函数，输入一个二叉树，输出它的镜像
 */
public class Solution19 {
    public void mirrorTree(BinaryTreeNode root){
        if(root==null){
            return;
        }
        BinaryTreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 对结点的左右两个子树进行处理
        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    public void printTree(BinaryTreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.value);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 8;
        root.left = new BinaryTreeNode();
        root.left.value=7;
        root.right = new BinaryTreeNode();
        root.right.value = 6;
        root.left.left = new BinaryTreeNode();
        root.left.left.value =5;
        root.left.right = new BinaryTreeNode();
        root.left.right.value=4;
        root.right.left = new BinaryTreeNode();
        root.right.left.value=3;


        Solution19 s19 = new Solution19();
        s19.printTree(root);
        System.out.println();
        System.out.println("镜像");
        s19.mirrorTree(root);
        s19.printTree(root);


    }

}
