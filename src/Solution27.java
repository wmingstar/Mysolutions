/**
 * Created by byuwa on 2017/3/27.
 * 输入一颗二叉搜索树，将其转换为一个排序的双向链表。
 */
public class Solution27 {

    public static BinaryTreeNode covert(BinaryTreeNode root){
        if(root == null){
            return null;
        }
        BinaryTreeNode[] last_node = new BinaryTreeNode[1];
        covertTree(root,last_node);
        BinaryTreeNode head = last_node[0];
        while (head!=null && head.left!=null){
            head=head.left;
        }
        return head;
    }

    public static void covertTree(BinaryTreeNode root,BinaryTreeNode[] last_node){
        if(root!=null){
            if(root.left!=null){
                covertTree(root.left,last_node);
            }
            root.left = last_node[0];
            if(last_node!=null){
                last_node[0].right = root;
            }
            last_node[0] = root;
            if(root.right!=null){
                covertTree(root.right,last_node);
            }
        }
    }



}
