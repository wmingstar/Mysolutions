import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by byuwa on 2017/3/27.
 * 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
 *
 * 树的层序遍历
 */
public class Solution23 {
    public static void printFromTopToBottom(BinaryTreeNode root){
        Queue queue = new ArrayDeque<BinaryTreeNode>();
        if(root == null){
            return;
        }
        queue.add(root);
        while(queue.size()!=0){
            BinaryTreeNode cur = (BinaryTreeNode) queue.poll();
            System.out.print(cur.value);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args){
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 6;
        root.left = new BinaryTreeNode();
        root.left.value = 5;
        root.right = new BinaryTreeNode();
        root.right.value = 4;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 3;
        root.left.right = new BinaryTreeNode();
        root.left.right.value =2;
        root.right.left = new BinaryTreeNode();
        root.right.left.value = 1;
        Solution23.printFromTopToBottom(root);
    }


}
