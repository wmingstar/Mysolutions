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

}
